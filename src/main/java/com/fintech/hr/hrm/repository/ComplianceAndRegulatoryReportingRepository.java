package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.ComplianceAndRegulatoryReporting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplianceAndRegulatoryReportingRepository
        extends MongoRepository<ComplianceAndRegulatoryReporting, String> {

    Optional<ComplianceAndRegulatoryReporting> findByReportId(String reportId);
}