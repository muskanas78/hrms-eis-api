package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.CompensationReview;
import com.fintech.hr.hrm.service.CompensationReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/compensation")
public class CompensationReviewController {

    @Autowired
    private CompensationReviewService service;

    /**
     * POST /compensation/review
     * Submit a compensation review
     */
    @PostMapping("/review")
    public Map<String, Object> submitReview(@RequestBody CompensationReview review) {
        CompensationReview saved = service.submitReview(review);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Compensation review submitted");
        response.put("reviewRef", saved.getReviewRef());
        response.put("id", saved.getId());
        return response;
    }

    /**
     * GET /compensation/{employeeId}
     * Retrieve review by employeeId
     */
    @GetMapping("/{employeeId}")
    public CompensationReview getReviewByEmployeeId(@PathVariable String employeeId) {
        return service.getReviewByEmployeeId(employeeId);
    }

    /**
     * GET /compensation
     * Retrieve all reviews
     */
    @GetMapping
    public List<CompensationReview> getAllReviews() {
        return service.getAllReviews();
    }

    /**
     * PATCH /compensation/{id}/status
     * Update review status
     */
    @PatchMapping("/{id}/status")
    public CompensationReview updateStatus(
            @PathVariable String id,
            @RequestBody Map<String, String> body
    ) {
        String newStatus = body.get("status");
        return service.updateReviewStatus(id, newStatus);
    }
}