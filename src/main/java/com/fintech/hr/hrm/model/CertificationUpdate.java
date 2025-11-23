package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "certifications")
public class CertificationUpdate {

    @Id
    private String id;
    private String certificationId;
    private String employeeId;
    private String certificationName;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String status; // e.g., "Active", "Expired", "Updated"

    public CertificationUpdate() {}

    public CertificationUpdate(String certificationId, String employeeId, String certificationName,
                               LocalDate issueDate, LocalDate expiryDate, String status) {
        this.certificationId = certificationId;
        this.employeeId = employeeId;
        this.certificationName = certificationName;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCertificationId() { return certificationId; }
    public void setCertificationId(String certificationId) { this.certificationId = certificationId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getCertificationName() { return certificationName; }
    public void setCertificationName(String certificationName) { this.certificationName = certificationName; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}