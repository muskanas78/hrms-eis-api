package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.AttendanceAnomalyReporting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceAnomalyReportingRepository extends MongoRepository<AttendanceAnomalyReporting, String> {

    Optional<AttendanceAnomalyReporting> findByAnomalyId(String anomalyId);

    List<AttendanceAnomalyReporting> findByEmployeeId(String employeeId);

    List<AttendanceAnomalyReporting> findByStatus(String status);
}