package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.WorkforcePlanSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkforcePlanSubmissionRepository extends MongoRepository<WorkforcePlanSubmission, String> {

    // Find plan by planId
    Optional<WorkforcePlanSubmission> findByPlanId(String planId);

    // Find plans by department
    List<WorkforcePlanSubmission> findByDepartment(String department);

    // Find plans by status
    List<WorkforcePlanSubmission> findByStatus(String status);

    // Find plans by submittedBy
    List<WorkforcePlanSubmission> findBySubmittedBy(String submittedBy);

    // Find plans by priority
    List<WorkforcePlanSubmission> findByPriority(String priority);
}