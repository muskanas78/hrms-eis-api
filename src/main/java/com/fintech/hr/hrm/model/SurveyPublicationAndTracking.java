package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "surveys")
public class SurveyPublicationAndTracking {

    @Id
    private String id;

    private String surveyId;              // e.g., SURV-2025-01
    private String title;                 // Survey title
    private String publishedBy;           // HR, Admin, etc.
    private List<String> targetAudience;  // e.g., ["All Employees"]
    private String status;                // DRAFT, PUBLISHED, CLOSED
    private List<String> responses;       // List of response IDs or comments

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SurveyPublicationAndTracking() {
        this.status = "DRAFT";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters + Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSurveyId() { return surveyId; }
    public void setSurveyId(String surveyId) { this.surveyId = surveyId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublishedBy() { return publishedBy; }
    public void setPublishedBy(String publishedBy) { this.publishedBy = publishedBy; }

    public List<String> getTargetAudience() { return targetAudience; }
    public void setTargetAudience(List<String> targetAudience) { this.targetAudience = targetAudience; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getResponses() { return responses; }
    public void setResponses(List<String> responses) { this.responses = responses; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}