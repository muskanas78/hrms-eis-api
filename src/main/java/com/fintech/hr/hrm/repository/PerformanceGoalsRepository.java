package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.PerformanceGoals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceGoalsRepository extends MongoRepository<PerformanceGoals, String> {

    List<PerformanceGoals> findByEmployeeId(String employeeId);
}