package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.EmployeeFeedback;
import com.fintech.hr.hrm.service.EmployeeFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/feedback")
public class EmployeeFeedbackController {

    @Autowired
    private EmployeeFeedbackService service;

    /**
     * POST /feedback
     * Submit employee feedback
     */
    @PostMapping
    public Map<String, Object> submitFeedback(@RequestBody EmployeeFeedback feedback) {
        EmployeeFeedback saved = service.submitFeedback(feedback);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Feedback submitted successfully");
        response.put("feedbackId", saved.getFeedbackId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /feedback/{employeeId}
     * Get feedback list for employee
     */
    @GetMapping("/{employeeId}")
    public List<EmployeeFeedback> getFeedbackByEmployee(@PathVariable String employeeId) {
        return service.getFeedbackByEmployeeId(employeeId);
    }

    /**
     * PUT /feedback/{feedbackId}
     * Update feedback content
     */
    @PutMapping("/{feedbackId}")
    public EmployeeFeedback updateFeedback(
            @PathVariable String feedbackId,
            @RequestBody EmployeeFeedback feedbackUpdate) {
        return service.updateFeedback(feedbackId, feedbackUpdate);
    }

    /**
     * DELETE /feedback/{feedbackId}
     * Delete a feedback entry
     */
    @DeleteMapping("/{feedbackId}")
    public Map<String, String> deleteFeedback(@PathVariable String feedbackId) {
        service.deleteFeedback(feedbackId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Feedback deleted successfully");
        response.put("feedbackId", feedbackId);

        return response;
    }
}