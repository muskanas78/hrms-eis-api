package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.BenefitEnrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BenefitEnrollmentRepository extends MongoRepository<BenefitEnrollment, String> {

    Optional<BenefitEnrollment> findByEmployeeId(String employeeId);

    List<BenefitEnrollment> findByStatus(String status);
}