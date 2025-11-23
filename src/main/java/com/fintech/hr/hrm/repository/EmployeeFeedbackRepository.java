package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.EmployeeFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeFeedbackRepository extends MongoRepository<EmployeeFeedback, String> {

    List<EmployeeFeedback> findByEmployeeId(String employeeId);
}