package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.WorkforcePlanSubmission;
import com.fintech.hr.hrm.service.WorkforcePlanSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/workforce-plans")
public class WorkforcePlanSubmissionController {

    @Autowired
    private WorkforcePlanSubmissionService service;

    /**
     * POST /workforce-plans
     * Submit new workforce plan
     */
    @PostMapping
    public Map<String, Object> submitPlan(@RequestBody WorkforcePlanSubmission plan) {
        WorkforcePlanSubmission savedPlan = service.submitPlan(plan);

        // Create response matching the required format
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Workforce plan submitted");
        response.put("planRefId", savedPlan.getPlanId());
        response.put("id", savedPlan.getId());
        response.put("details", savedPlan);

        return response;
    }

    /**
     * GET /workforce-plans/{id}
     * Retrieve plan details by MongoDB ID
     */
    @GetMapping("/{id}")
    public WorkforcePlanSubmission getPlanById(@PathVariable String id) {
        return service.getPlanById(id);
    }

    /**
     * GET /workforce-plans/plan/{planId}
     * Retrieve plan by planId (e.g., WP-2025-Q4)
     */
    @GetMapping("/plan/{planId}")
    public WorkforcePlanSubmission getPlanByPlanId(@PathVariable String planId) {
        return service.getPlanByPlanId(planId);
    }

    /**
     * GET /workforce-plans
     * Get all plans
     */
    @GetMapping
    public List<WorkforcePlanSubmission> getAllPlans() {
        return service.getAllPlans();
    }

    /**
     * GET /workforce-plans/department/{department}
     * Get plans by department
     */
    @GetMapping("/department/{department}")
    public List<WorkforcePlanSubmission> getPlansByDepartment(@PathVariable String department) {
        return service.getPlansByDepartment(department);
    }

    /**
     * GET /workforce-plans/status/{status}
     * Get plans by status (PENDING, APPROVED, REJECTED)
     */
    @GetMapping("/status/{status}")
    public List<WorkforcePlanSubmission> getPlansByStatus(@PathVariable String status) {
        return service.getPlansByStatus(status);
    }

    /**
     * GET /workforce-plans/submittedby/{submittedBy}
     * Get plans by submitter
     */
    @GetMapping("/submittedby/{submittedBy}")
    public List<WorkforcePlanSubmission> getPlansBySubmittedBy(@PathVariable String submittedBy) {
        return service.getPlansBySubmittedBy(submittedBy);
    }

    /**
     * PATCH /workforce-plans/{id}/status
     * Update plan status (for approval/rejection)
     */
    @PatchMapping("/{id}/status")
    public WorkforcePlanSubmission updatePlanStatus(
            @PathVariable String id,
            @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");
        return service.updatePlanStatus(id, newStatus);
    }

    /**
     * PUT /workforce-plans/{id}
     * Update plan details
     */
    @PutMapping("/{id}")
    public WorkforcePlanSubmission updatePlan(
            @PathVariable String id,
            @RequestBody WorkforcePlanSubmission updatedPlan) {
        return service.updatePlan(id, updatedPlan);
    }

    /**
     * DELETE /workforce-plans/{id}
     * Delete a plan
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deletePlan(@PathVariable String id) {
        service.deletePlan(id);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Workforce plan deleted successfully");
        response.put("id", id);

        return response;
    }
}