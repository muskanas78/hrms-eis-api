package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.BenefitEnrollment;
import com.fintech.hr.hrm.service.BenefitEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/benefits")
public class BenefitEnrollmentController {

    @Autowired
    private BenefitEnrollmentService service;

    /**
     * POST /benefits/enroll
     * Enroll an employee in a benefit
     */
    @PostMapping("/enroll")
    public BenefitEnrollment enroll(@RequestBody BenefitEnrollment enrollment) {
        return service.enroll(enrollment);
    }

    /**
     * GET /benefits/{employeeId}
     * Fetch enrollment details for a specific employee
     */
    @GetMapping("/{employeeId}")
    public BenefitEnrollment getEnrollment(@PathVariable String employeeId) {
        return service.getEnrollment(employeeId);
    }

    /**
     * PUT /benefits/{employeeId}
     * Update enrollment details
     */
    @PutMapping("/{employeeId}")
    public BenefitEnrollment updateEnrollment(
            @PathVariable String employeeId,
            @RequestBody BenefitEnrollment updated) {
        return service.updateEnrollment(employeeId, updated);
    }

    /**
     * DELETE /benefits/{employeeId}
     * Remove an enrollment record
     */
    @DeleteMapping("/{employeeId}")
    public Map<String, String> deleteEnrollment(@PathVariable String employeeId) {
        service.deleteEnrollment(employeeId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Benefit enrollment deleted successfully");
        response.put("employeeId", employeeId);
        return response;
    }

    /**
     * GET /benefits
     * Fetch all benefit enrollments
     */
    @GetMapping
    public List<BenefitEnrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }
}