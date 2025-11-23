package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.WorkforceDemandForecasting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkforceDemandForecastingRepository extends MongoRepository<WorkforceDemandForecasting, String> {

    // Find forecast by period (e.g., "Q4-2025")
    List<WorkforceDemandForecasting> findByPeriod(String period);

    // Find forecast by forecastId
    Optional<WorkforceDemandForecasting> findByForecastId(String forecastId);

    // Find by department
    List<WorkforceDemandForecasting> findByDepartment(String department);

    // Find by status
    List<WorkforceDemandForecasting> findByStatus(String status);

    // Find by period and department
    List<WorkforceDemandForecasting> findByPeriodAndDepartment(String period, String department);
}