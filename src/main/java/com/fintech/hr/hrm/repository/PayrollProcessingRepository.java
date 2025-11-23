package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.PayrollProcessing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayrollProcessingRepository extends MongoRepository<PayrollProcessing, String> {

    Optional<PayrollProcessing> findByCycleMonth(String cycleMonth);

    void deleteByCycleMonth(String cycleMonth);
}