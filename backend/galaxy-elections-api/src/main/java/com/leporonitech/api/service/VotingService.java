package com.leporonitech.api.service;

import com.leporonitech.api.model.CandidateModel;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotingService {

    private static final String VOTING_TOPIC = "voting";

    private final KafkaTemplate<Object, Object> template;

    public void addEvent(CandidateModel candidate) {
        template.send(VOTING_TOPIC, candidate);
    }
}
