package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.EmployeeOnboarding;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeOnboardingRepository extends MongoRepository<EmployeeOnboarding, String> {

    Optional<EmployeeOnboarding> findByEmployeeId(String employeeId);

    List<EmployeeOnboarding> findByDepartment(String department);

    List<EmployeeOnboarding> findByStatus(String status);
}