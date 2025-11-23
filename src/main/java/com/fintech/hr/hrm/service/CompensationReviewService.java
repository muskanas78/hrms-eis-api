package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.CompensationReview;
import com.fintech.hr.hrm.repository.CompensationReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompensationReviewService {

    @Autowired
    private CompensationReviewRepository repository;

    /**
     * Submit a new compensation review (POST /compensation/review)
     */
    public CompensationReview submitReview(CompensationReview review) {
        if (review.getReviewRef() == null || review.getReviewRef().isEmpty()) {
            String ref = "CR-" + LocalDateTime.now().getYear() + "-" + System.currentTimeMillis();
            review.setReviewRef(ref);
        }

        review.setStatus("SUBMITTED");
        review.setReviewedAt(LocalDateTime.now());
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        return repository.save(review);
    }

    /**
     * Get review by employeeId (GET /compensation/{employeeId})
     */
    public CompensationReview getReviewByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No compensation review found for employeeId: " + employeeId));
    }

    /**
     * Get all reviews
     */
    public List<CompensationReview> getAllReviews() {
        return repository.findAll();
    }

    /**
     * Get reviews by status
     */
    public List<CompensationReview> getReviewsByStatus(String status) {
        return repository.findByStatus(status);
    }

    /**
     * Update status (e.g., APPROVED/REJECTED)
     */
    public CompensationReview updateReviewStatus(String id, String newStatus) {
        CompensationReview review = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compensation review not found with id: " + id));

        review.setStatus(newStatus);
        review.setUpdatedAt(LocalDateTime.now());
        return repository.save(review);
    }
}