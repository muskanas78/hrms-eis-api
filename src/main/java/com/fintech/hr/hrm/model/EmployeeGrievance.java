package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "employee_grievances")
public class EmployeeGrievance {

    @Id
    private String id;
    private String grievanceId;
    private String employeeId;
    private String issue;
    private String submittedBy;
    private String status; // e.g. "SUBMITTED", "UNDER_REVIEW", "RESOLVED", "REJECTED"
    private LocalDateTime submittedAt;
    private LocalDateTime updatedAt;

    public EmployeeGrievance() {
        this.status = "SUBMITTED";
        this.submittedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public EmployeeGrievance(String grievanceId, String employeeId, String issue, String submittedBy, String status) {
        this.grievanceId = grievanceId;
        this.employeeId = employeeId;
        this.issue = issue;
        this.submittedBy = submittedBy;
        this.status = status;
        this.submittedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrievanceId() { return grievanceId; }
    public void setGrievanceId(String grievanceId) { this.grievanceId = grievanceId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getIssue() { return issue; }
    public void setIssue(String issue) { this.issue = issue; }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}