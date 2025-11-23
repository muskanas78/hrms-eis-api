package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.PerformanceReview;
import com.fintech.hr.hrm.service.PerformanceReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/performance/reviews")
public class PerformanceReviewController {

    @Autowired
    private PerformanceReviewService service;

    // POST /reviews → Submit review
    @PostMapping
    public Map<String, Object> submitReview(@RequestBody PerformanceReview review) {
        PerformanceReview saved = service.submitReview(review);

        Map<String, Object> response = new HashMap<>();
        response.put("reviewId", saved.getReviewId());
        response.put("status", saved.getStatus());
        response.put("message", "Performance review submitted successfully");
        response.put("details", saved);
        return response;
    }

    // GET /reviews/{employeeId} → Fetch review
    @GetMapping("/{employeeId}")
    public PerformanceReview getReview(@PathVariable String employeeId) {
        return service.getReviewByEmployeeId(employeeId);
    }

    // PUT /reviews/{reviewId} → Update review
    @PutMapping("/{reviewId}")
    public PerformanceReview updateReview(@PathVariable String reviewId, @RequestBody PerformanceReview updatedReview) {
        return service.updateReview(reviewId, updatedReview);
    }

    // DELETE /reviews/{reviewId} → Delete review
    @DeleteMapping("/{reviewId}")
    public Map<String, String> deleteReview(@PathVariable String reviewId) {
        service.deleteReview(reviewId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Performance review deleted successfully");
        response.put("reviewId", reviewId);
        return response;
    }

    // GET /reviews → fetch all reviews
    @GetMapping
    public List<PerformanceReview> getAllReviews() {
        return service.getAllReviews();
    }
}