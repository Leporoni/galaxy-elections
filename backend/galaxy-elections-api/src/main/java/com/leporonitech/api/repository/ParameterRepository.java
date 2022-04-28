package com.leporonitech.api.repository;

import com.leporonitech.api.model.ParameterModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {

}
