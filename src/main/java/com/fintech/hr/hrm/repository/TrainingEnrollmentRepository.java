package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.TrainingEnrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TrainingEnrollmentRepository extends MongoRepository<TrainingEnrollment, String> {

    Optional<TrainingEnrollment> findByEmployeeIdAndTrainingId(String employeeId, String trainingId);

    List<TrainingEnrollment> findByEmployeeId(String employeeId);

    List<TrainingEnrollment> findByStatus(String status);
}