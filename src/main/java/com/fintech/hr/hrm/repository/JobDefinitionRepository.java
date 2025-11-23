package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.JobDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDefinitionRepository extends MongoRepository<JobDefinition, String> {
    // Spring automatically provides: save(), findAll(), findById(), deleteById(), etc.
}