package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "training_enrollments")
public class TrainingEnrollment {

    @Id
    private String id;
    private String enrollmentId;
    private String employeeId;
    private String trainingId;
    private String enrolledBy; // e.g., HR
    private String status;     // e.g., "Enrolled", "Completed", "Cancelled"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TrainingEnrollment() {
        this.status = "Enrolled";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public TrainingEnrollment(String enrollmentId, String employeeId, String trainingId, String enrolledBy, String status) {
        this.enrollmentId = enrollmentId;
        this.employeeId = employeeId;
        this.trainingId = trainingId;
        this.enrolledBy = enrolledBy;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getTrainingId() { return trainingId; }
    public void setTrainingId(String trainingId) { this.trainingId = trainingId; }

    public String getEnrolledBy() { return enrolledBy; }
    public void setEnrolledBy(String enrolledBy) { this.enrolledBy = enrolledBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}