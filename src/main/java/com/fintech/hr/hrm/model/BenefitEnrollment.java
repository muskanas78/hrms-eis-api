package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "benefit_enrollments")
public class BenefitEnrollment {

    @Id
    private String id;
    private String enrollmentId;
    private String employeeId;
    private String benefitType; // e.g., "Health Insurance", "Life Insurance"
    private String plan;        // e.g., "Basic", "Premium"
    private String enrolledBy;  // e.g., "HR"
    private String status;      // "Enrolled" or "Cancelled"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BenefitEnrollment() {
        this.status = "Enrolled";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public BenefitEnrollment(String enrollmentId, String employeeId, String benefitType,
                             String plan, String enrolledBy, String status) {
        this.enrollmentId = enrollmentId;
        this.employeeId = employeeId;
        this.benefitType = benefitType;
        this.plan = plan;
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

    public String getBenefitType() { return benefitType; }
    public void setBenefitType(String benefitType) { this.benefitType = benefitType; }

    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }

    public String getEnrolledBy() { return enrolledBy; }
    public void setEnrolledBy(String enrolledBy) { this.enrolledBy = enrolledBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}