package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "final_selection_status")
public class FinalSelectionStatus {

    @Id
    private String id;
    private String candidateId;
    private String status;         // e.g. "SELECTED", "REJECTED", "ON_HOLD"
    private String approvedBy;     // e.g. "HR-MANAGER"
    private String remarks;        // optional comments
    private LocalDateTime decisionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FinalSelectionStatus() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.decisionDate = LocalDateTime.now();
    }

    public FinalSelectionStatus(String id, String candidateId, String status, String approvedBy, String remarks) {
        this.id = id;
        this.candidateId = candidateId;
        this.status = status;
        this.approvedBy = approvedBy;
        this.remarks = remarks;
        this.decisionDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getApprovedBy() {
        return approvedBy;
    }
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public LocalDateTime getDecisionDate() {
        return decisionDate;
    }
    public void setDecisionDate(LocalDateTime decisionDate) {
        this.decisionDate = decisionDate;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}