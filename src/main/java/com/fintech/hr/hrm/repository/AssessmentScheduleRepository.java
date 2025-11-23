package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.AssessmentSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssessmentScheduleRepository extends MongoRepository<AssessmentSchedule, String> {

    Optional<AssessmentSchedule> findByAssessmentId(String assessmentId);

}