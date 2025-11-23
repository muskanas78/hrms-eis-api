package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.LeaveAndAbsenceManagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface LeaveAndAbsenceManagementRepository extends MongoRepository<LeaveAndAbsenceManagement, String> {

    Optional<LeaveAndAbsenceManagement> findByLeaveId(String leaveId);

    List<LeaveAndAbsenceManagement> findByEmployeeId(String employeeId);

    List<LeaveAndAbsenceManagement> findByStatus(String status);
}