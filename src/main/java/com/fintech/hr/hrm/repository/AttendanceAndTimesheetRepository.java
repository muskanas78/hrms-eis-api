package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.AttendanceAndTimesheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceAndTimesheetRepository extends MongoRepository<AttendanceAndTimesheet, String> {

    List<AttendanceAndTimesheet> findByEmployeeIdAndTimestampBetween(
            String employeeId, LocalDateTime start, LocalDateTime end);
}