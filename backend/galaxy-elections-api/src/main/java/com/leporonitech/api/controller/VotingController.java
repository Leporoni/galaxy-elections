package com.leporonitech.api.controller;

import com.leporonitech.api.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import com.leporonitech.api.model.CandidateModel;
import com.leporonitech.api.service.VotingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
@CrossOrigin
public class VotingController {

    private final VotingService service;
    private final CandidateRepository repository;

    @PostMapping
    public ResponseEntity<CandidateModel> vote(@RequestBody CandidateModel candidate) {

        Optional<CandidateModel> responseOpt = repository.findById(candidate.getId());
        if (responseOpt.isEmpty()) {
            throw new RuntimeException("Code [" + candidate.getId() + "] invalid for voting...");
        }

        CandidateModel response = responseOpt.get();

        service.addEvent(response);
        return ResponseEntity.ok(response);
    }

}
