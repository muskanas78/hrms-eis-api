package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.TrainingEnrollment;
import com.fintech.hr.hrm.service.TrainingEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/training/enrollments")
public class TrainingEnrollmentController {

    @Autowired
    private TrainingEnrollmentService service;

    /**
     * POST /enroll
     */
    @PostMapping("/enroll")
    public TrainingEnrollment enrollEmployee(@RequestBody TrainingEnrollment enrollment) {
        return service.enrollEmployee(enrollment);
    }

    /**
     * GET /enrollments/{employeeId}
     */
    @GetMapping("/{employeeId}")
    public List<TrainingEnrollment> getEnrollments(@PathVariable String employeeId) {
        return service.getEnrollmentsByEmployeeId(employeeId);
    }

    /**
     * PUT /{enrollmentId}
     */
    @PutMapping("/{enrollmentId}")
    public TrainingEnrollment updateStatus(@PathVariable String enrollmentId, @RequestBody Map<String, String> request) {
        String newStatus = request.get("status");
        return service.updateEnrollmentStatus(enrollmentId, newStatus);
    }

    /**
     * DELETE /{enrollmentId}
     */
    @DeleteMapping("/{enrollmentId}")
    public Map<String, String> deleteEnrollment(@PathVariable String enrollmentId) {
        service.deleteEnrollment(enrollmentId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Enrollment deleted successfully");
        response.put("enrollmentId", enrollmentId);
        return response;
    }
}