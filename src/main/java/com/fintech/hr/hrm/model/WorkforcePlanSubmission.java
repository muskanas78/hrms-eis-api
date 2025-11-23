package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "workforce_plan_submissions")
public class WorkforcePlanSubmission {

    @Id
    private String id;
    private String planId;
    private String department;
    private Integer headcountRequired;
    private String submittedBy;
    private String status; // "PENDING", "APPROVED", "REJECTED"
    private String justification;
    private String priority; // "HIGH", "MEDIUM", "LOW"
    private LocalDateTime submittedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor
    public WorkforcePlanSubmission() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Full constructor
    public WorkforcePlanSubmission(String id, String planId, String department, Integer headcountRequired,
                                   String submittedBy, String status, String justification, String priority,
                                   LocalDateTime submittedDate) {
        this.id = id;
        this.planId = planId;
        this.department = department;
        this.headcountRequired = headcountRequired;
        this.submittedBy = submittedBy;
        this.status = status;
        this.justification = justification;
        this.priority = priority;
        this.submittedDate = submittedDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getHeadcountRequired() {
        return headcountRequired;
    }

    public void setHeadcountRequired(Integer headcountRequired) {
        this.headcountRequired = headcountRequired;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDateTime submittedDate) {
        this.submittedDate = submittedDate;
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