package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.WorkforcePlanSubmission;
import com.fintech.hr.hrm.repository.WorkforcePlanSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkforcePlanSubmissionService {

    @Autowired
    private WorkforcePlanSubmissionRepository repository;

    /**
     * Submit new workforce plan (POST /workforce-plans)
     */
    public WorkforcePlanSubmission submitPlan(WorkforcePlanSubmission plan) {
        // Auto-generate planId if not provided
        if (plan.getPlanId() == null || plan.getPlanId().isEmpty()) {
            String planId = "WP-" + System.currentTimeMillis();
            plan.setPlanId(planId);
        }

        // Set default values
        plan.setStatus("PENDING");
        plan.setSubmittedDate(LocalDateTime.now());
        plan.setCreatedAt(LocalDateTime.now());
        plan.setUpdatedAt(LocalDateTime.now());

        // Save to MongoDB
        return repository.save(plan);
    }

    /**
     * Get plan by MongoDB ID (GET /workforce-plans/{id})
     */
    public WorkforcePlanSubmission getPlanById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workforce plan not found with id: " + id));
    }

    /**
     * Get plan by planId
     */
    public WorkforcePlanSubmission getPlanByPlanId(String planId) {
        return repository.findByPlanId(planId)
                .orElseThrow(() -> new RuntimeException("Workforce plan not found with planId: " + planId));
    }

    /**
     * Get all plans
     */
    public List<WorkforcePlanSubmission> getAllPlans() {
        return repository.findAll();
    }

    /**
     * Get plans by department
     */
    public List<WorkforcePlanSubmission> getPlansByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    /**
     * Get plans by status
     */
    public List<WorkforcePlanSubmission> getPlansByStatus(String status) {
        return repository.findByStatus(status);
    }

    /**
     * Get plans by submittedBy
     */
    public List<WorkforcePlanSubmission> getPlansBySubmittedBy(String submittedBy) {
        return repository.findBySubmittedBy(submittedBy);
    }

    /**
     * Update plan status (for approval/rejection)
     */
    public WorkforcePlanSubmission updatePlanStatus(String id, String newStatus) {
        WorkforcePlanSubmission plan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workforce plan not found with id: " + id));

        plan.setStatus(newStatus);
        plan.setUpdatedAt(LocalDateTime.now());

        return repository.save(plan);
    }

    /**
     * Update plan details
     */
    public WorkforcePlanSubmission updatePlan(String id, WorkforcePlanSubmission updatedPlan) {
        WorkforcePlanSubmission existingPlan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workforce plan not found with id: " + id));

        // Update fields
        if (updatedPlan.getDepartment() != null) {
            existingPlan.setDepartment(updatedPlan.getDepartment());
        }
        if (updatedPlan.getHeadcountRequired() != null) {
            existingPlan.setHeadcountRequired(updatedPlan.getHeadcountRequired());
        }
        if (updatedPlan.getJustification() != null) {
            existingPlan.setJustification(updatedPlan.getJustification());
        }
        if (updatedPlan.getPriority() != null) {
            existingPlan.setPriority(updatedPlan.getPriority());
        }

        existingPlan.setUpdatedAt(LocalDateTime.now());

        return repository.save(existingPlan);
    }

    /**
     * Delete plan
     */
    public void deletePlan(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Workforce plan not found with id: " + id);
        }
        repository.deleteById(id);
    }
}