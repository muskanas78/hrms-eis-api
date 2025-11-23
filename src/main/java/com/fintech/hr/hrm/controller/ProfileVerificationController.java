package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.ProfileVerification;
import com.fintech.hr.hrm.service.ProfileVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profile-verification")
public class ProfileVerificationController {

    @Autowired
    private ProfileVerificationService service;

    // POST /api/v1/profile-verification/verify
    @PostMapping("/verify")
    public Map<String, Object> submitProfileVerification(@RequestBody ProfileVerification verification) {
        ProfileVerification saved = service.submitVerification(verification);

        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getId());
        response.put("verificationId", saved.getVerificationId());
        response.put("status", saved.getStatus());
        response.put("message", saved.getMessage());
        response.put("submittedBy", saved.getSubmittedBy());
        return response;
    }

    // GET /api/v1/profile-verification/verify/{id}
    @GetMapping("/verify/{id}")
    public Map<String, Object> getVerificationStatus(@PathVariable String id) {
        ProfileVerification verification = service.getVerificationById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", verification.getId());
        response.put("verificationId", verification.getVerificationId());
        response.put("employeeId", verification.getEmployeeId());
        response.put("status", verification.getStatus());
        response.put("message", verification.getMessage());
        response.put("submittedBy", verification.getSubmittedBy());
        return response;
    }

    // GET /api/v1/profile-verification
    @GetMapping
    public List<ProfileVerification> getAllVerifications() {
        return service.getAllVerifications();
    }

    // PATCH /api/v1/profile-verification/verify/{id}/status
    @PatchMapping("/verify/{id}/status")
    public Map<String, Object> updateStatus(@PathVariable String id, @RequestBody Map<String, String> body) {
        String newStatus = body.get("status");
        String message = body.getOrDefault("message", "Status updated");
        ProfileVerification updated = service.updateStatus(id, newStatus, message);

        Map<String, Object> response = new HashMap<>();
        response.put("id", updated.getId());
        response.put("verificationId", updated.getVerificationId());
        response.put("status", updated.getStatus());
        response.put("message", updated.getMessage());
        return response;
    }
}