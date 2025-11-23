package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "profile_verifications")
public class ProfileVerification {

    @Id
    private String id;                      // MongoDB internal ID
    private String verificationId;          // e.g. VER-1072
    private String employeeId;              // e.g. EMP-1072
    private List<String> documents;         // ["ID Proof", "Degree"]
    private String submittedBy;             // e.g. "HR-MANAGER"
    private String status;                  // "Pending", "Verified", "Rejected"
    private String message;                 // "Verification in progress"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor
    public ProfileVerification() {
        this.status = "Pending";
        this.message = "Verification in progress";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Full constructor
    public ProfileVerification(String verificationId, String employeeId, List<String> documents,
                               String submittedBy, String status, String message) {
        this.verificationId = verificationId;
        this.employeeId = employeeId;
        this.documents = documents;
        this.submittedBy = submittedBy;
        this.status = status;
        this.message = message;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getVerificationId() { return verificationId; }
    public void setVerificationId(String verificationId) { this.verificationId = verificationId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public List<String> getDocuments() { return documents; }
    public void setDocuments(List<String> documents) { this.documents = documents; }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}