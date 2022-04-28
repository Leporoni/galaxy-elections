package com.leporonitech.ms.repository;

import com.leporonitech.ms.model.VotingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotingRepository extends MongoRepository<VotingModel, String> {
}
