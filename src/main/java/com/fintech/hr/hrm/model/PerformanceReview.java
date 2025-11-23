package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "performance_reviews")
public class PerformanceReview {

    @Id
    private String id;
    private String reviewId;
    private String employeeId;
    private String reviewPeriod; // e.g., "2025-Q3"
    private int score;
    private String reviewedBy;
    private String status; // Submitted, Approved, Pending
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PerformanceReview() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = "Pending";
    }

    public PerformanceReview(String reviewId, String employeeId, String reviewPeriod, int score, String reviewedBy, String status) {
        this.reviewId = reviewId;
        this.employeeId = employeeId;
        this.reviewPeriod = reviewPeriod;
        this.score = score;
        this.reviewedBy = reviewedBy;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getReviewId() { return reviewId; }
    public void setReviewId(String reviewId) { this.reviewId = reviewId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getReviewPeriod() { return reviewPeriod; }
    public void setReviewPeriod(String reviewPeriod) { this.reviewPeriod = reviewPeriod; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getReviewedBy() { return reviewedBy; }
    public void setReviewedBy(String reviewedBy) { this.reviewedBy = reviewedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}