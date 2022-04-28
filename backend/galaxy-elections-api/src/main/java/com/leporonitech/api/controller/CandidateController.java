package com.leporonitech.api.controller;

import com.leporonitech.api.model.CandidateModel;
import com.leporonitech.api.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
@AllArgsConstructor
@CrossOrigin
public class CandidateController {

    private final CandidateRepository repository;

    @PostMapping("/save")
    public ResponseEntity<CandidateModel> save(@RequestBody CandidateModel candidate) {
        CandidateModel entity = repository.save(candidate);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consult")
    public ResponseEntity<CandidateModel> consult(@RequestParam String id) {
        Optional<CandidateModel> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opt.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateModel>> all() {
        List<CandidateModel> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
}
