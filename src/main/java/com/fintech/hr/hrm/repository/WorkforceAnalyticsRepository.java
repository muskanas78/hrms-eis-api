package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.WorkforceAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkforceAnalyticsRepository extends MongoRepository<WorkforceAnalytics, String> {

    Optional<WorkforceAnalytics> findByReportId(String reportId);

}