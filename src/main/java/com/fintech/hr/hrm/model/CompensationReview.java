package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "compensation_reviews")
public class CompensationReview {

    @Id
    private String id;
    private String employeeId;
    private Double currentSalary;
    private Double proposedRevision;
    private String reviewedBy;
    private String reviewRef;
    private String status; // "PENDING", "APPROVED", "REJECTED"
    private LocalDateTime reviewedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompensationReview() {
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.reviewedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public Double getCurrentSalary() { return currentSalary; }
    public void setCurrentSalary(Double currentSalary) { this.currentSalary = currentSalary; }

    public Double getProposedRevision() { return proposedRevision; }
    public void setProposedRevision(Double proposedRevision) { this.proposedRevision = proposedRevision; }

    public String getReviewedBy() { return reviewedBy; }
    public void setReviewedBy(String reviewedBy) { this.reviewedBy = reviewedBy; }

    public String getReviewRef() { return reviewRef; }
    public void setReviewRef(String reviewRef) { this.reviewRef = reviewRef; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getReviewedAt() { return reviewedAt; }
    public void setReviewedAt(LocalDateTime reviewedAt) { this.reviewedAt = reviewedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}