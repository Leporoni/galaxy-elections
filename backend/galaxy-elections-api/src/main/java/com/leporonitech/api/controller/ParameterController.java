package com.leporonitech.api.controller;

import com.leporonitech.api.repository.ParameterRepository;
import com.leporonitech.api.model.ParameterModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {

    private final ParameterRepository repository;

    public ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameter) {
        ParameterModel entity = repository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consult")
    public ResponseEntity<ParameterModel> consult(@RequestParam String key) {
        Optional<ParameterModel> optParameter = repository.findById(key);
        if (optParameter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optParameter.get());
    }
}
