package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "assessment_schedules")
public class AssessmentSchedule {

    @Id
    private String id;
    private String assessmentId;
    private String candidateId;
    private String assessmentType;
    private String scheduledDate;
    private String scheduledBy;
    private String status; // Scheduled, Completed, Cancelled
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AssessmentSchedule() {
        this.status = "Scheduled";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AssessmentSchedule(String candidateId, String assessmentType, String scheduledDate, String scheduledBy) {
        this.assessmentId = "ASMT-" + System.currentTimeMillis();
        this.candidateId = candidateId;
        this.assessmentType = assessmentType;
        this.scheduledDate = scheduledDate;
        this.scheduledBy = scheduledBy;
        this.status = "Scheduled";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }

    public String getCandidateId() { return candidateId; }
    public void setCandidateId(String candidateId) { this.candidateId = candidateId; }

    public String getAssessmentType() { return assessmentType; }
    public void setAssessmentType(String assessmentType) { this.assessmentType = assessmentType; }

    public String getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(String scheduledDate) { this.scheduledDate = scheduledDate; }

    public String getScheduledBy() { return scheduledBy; }
    public void setScheduledBy(String scheduledBy) { this.scheduledBy = scheduledBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}