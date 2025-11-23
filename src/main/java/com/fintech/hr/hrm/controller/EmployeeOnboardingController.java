package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.EmployeeOnboarding;
import com.fintech.hr.hrm.service.EmployeeOnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/onboarding")
public class EmployeeOnboardingController {

    @Autowired
    private EmployeeOnboardingService service;

    /**
     * POST /onboarding
     * Start onboarding for a new employee
     */
    @PostMapping
    public Map<String, Object> startOnboarding(@RequestBody EmployeeOnboarding onboarding) {
        EmployeeOnboarding saved = service.startOnboarding(onboarding);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee onboarding started successfully");
        response.put("onboardingId", saved.getOnboardingId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /onboarding/{employeeId}
     * Retrieve onboarding progress
     */
    @GetMapping("/{employeeId}")
    public EmployeeOnboarding getOnboarding(@PathVariable String employeeId) {
        return service.getOnboardingByEmployeeId(employeeId);
    }

    /**
     * GET /onboarding
     * Retrieve all onboarding records
     */
    @GetMapping
    public List<EmployeeOnboarding> getAllOnboardings() {
        return service.getAllOnboardings();
    }

    /**
     * PATCH /onboarding/{employeeId}/progress
     * Mark a specific task as completed
     */
    @PatchMapping("/{employeeId}/progress")
    public EmployeeOnboarding updateProgress(
            @PathVariable String employeeId,
            @RequestBody Map<String, String> request) {
        String completedTask = request.get("task");
        return service.updateProgress(employeeId, completedTask);
    }

    /**
     * PATCH /onboarding/{employeeId}/status
     * Manually update onboarding status
     */
    @PatchMapping("/{employeeId}/status")
    public EmployeeOnboarding updateStatus(
            @PathVariable String employeeId,
            @RequestBody Map<String, String> request) {
        String newStatus = request.get("status");
        return service.updateStatus(employeeId, newStatus);
    }

    /**
     * DELETE /onboarding/{employeeId}
     * Remove onboarding record
     */
    @DeleteMapping("/{employeeId}")
    public Map<String, String> deleteOnboarding(@PathVariable String employeeId) {
        service.deleteOnboarding(employeeId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee onboarding deleted successfully");
        response.put("employeeId", employeeId);

        return response;
    }
}