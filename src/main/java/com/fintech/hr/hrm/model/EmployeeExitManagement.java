package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "employee_exits")
public class EmployeeExitManagement {

    @Id
    private String id;

    private String exitId;
    private String employeeId;
    private String exitDate;
    private String reason;
    private String initiatedBy;
    private String status; // e.g., "IN_PROGRESS", "PENDING_APPROVAL", "COMPLETED"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmployeeExitManagement() {
        this.status = "IN_PROGRESS";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public EmployeeExitManagement(String exitId, String employeeId, String exitDate,
                                  String reason, String initiatedBy, String status) {
        this.exitId = exitId;
        this.employeeId = employeeId;
        this.exitDate = exitDate;
        this.reason = reason;
        this.initiatedBy = initiatedBy;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters & Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getExitId() { return exitId; }
    public void setExitId(String exitId) { this.exitId = exitId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getExitDate() { return exitDate; }
    public void setExitDate(String exitDate) { this.exitDate = exitDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getInitiatedBy() { return initiatedBy; }
    public void setInitiatedBy(String initiatedBy) { this.initiatedBy = initiatedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}