package com.leporonitech.api.repository;

import com.leporonitech.api.model.CandidateModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<CandidateModel, String> {
}
