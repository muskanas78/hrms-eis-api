package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.HRFinanceSync;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HRFinanceSyncRepository extends MongoRepository<HRFinanceSync, String> {

    Optional<HRFinanceSync> findByBatchId(String batchId);

    void deleteByBatchId(String batchId);
}