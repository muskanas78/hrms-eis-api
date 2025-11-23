package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.EmployeeExitManagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeExitManagementRepository extends MongoRepository<EmployeeExitManagement, String> {

    Optional<EmployeeExitManagement> findByEmployeeId(String employeeId);

    Optional<EmployeeExitManagement> findByExitId(String exitId);
}