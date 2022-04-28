package com.leporonitech.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leporonitech.ms.model.CandidateModel;
import com.leporonitech.ms.model.VotingModel;
import com.leporonitech.ms.repository.VotingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotingService {

    private final VotingRepository repository;

    @KafkaListener(topics = "voting", groupId = "MicroServiceVoting")
    private void exec(ConsumerRecord<String, String> record) {

        String candidateStr = record.value();
        log.info("Vote received = {}", candidateStr);

        ObjectMapper mapper = new ObjectMapper();
        CandidateModel candidate = null;

        try {
            candidate = mapper.readValue(candidateStr, CandidateModel.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to convert vote [{}]", candidateStr, e);
            return;
        }

        VotingModel voting = new VotingModel(null, candidate, new Date());
        VotingModel entity = repository.save(voting);

        log.info("Vote registered successfully [id={}, dateTime={}]", entity.getId(), entity.getDateTime());
    }

}
