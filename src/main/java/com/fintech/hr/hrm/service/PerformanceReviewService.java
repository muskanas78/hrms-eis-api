package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.PerformanceReview;
import com.fintech.hr.hrm.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PerformanceReviewService {

    @Autowired
    private PerformanceReviewRepository repository;

    /**
     * Submit a new performance review
     */
    public PerformanceReview submitReview(PerformanceReview review) {
        if (review.getReviewId() == null || review.getReviewId().isEmpty()) {
            review.setReviewId("PR-" + review.getEmployeeId() + "-" + review.getReviewPeriod().replace("-", ""));
        }
        review.setStatus("Submitted");
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return repository.save(review);
    }

    /**
     * Fetch review by employeeId
     */
    public PerformanceReview getReviewByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No review found for employeeId: " + employeeId));
    }

    /**
     * Update review
     */
    public PerformanceReview updateReview(String reviewId, PerformanceReview updatedReview) {
        PerformanceReview existing = repository.findByReviewId(reviewId)
                .orElseThrow(() -> new RuntimeException("No review found for reviewId: " + reviewId));

        existing.setScore(updatedReview.getScore());
        existing.setReviewedBy(updatedReview.getReviewedBy());
        existing.setStatus(updatedReview.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * Delete review
     */
    public void deleteReview(String reviewId) {
        PerformanceReview review = repository.findByReviewId(reviewId)
                .orElseThrow(() -> new RuntimeException("No review found for reviewId: " + reviewId));
        repository.delete(review);
    }

    /**
     * Fetch all reviews
     */
    public List<PerformanceReview> getAllReviews() {
        return repository.findAll();
    }
}