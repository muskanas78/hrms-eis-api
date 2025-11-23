package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "leaves")
public class LeaveAndAbsenceManagement {

    @Id
    private String id;

    private String leaveId;
    private String employeeId;
    private String leaveType; // e.g., Annual Leave, Sick Leave
    private String startDate;
    private String endDate;
    private String reason;

    private String status; // PENDING, APPROVED, REJECTED, CANCELLED
    private String policyCheck; // Valid, Invalid

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LeaveAndAbsenceManagement() {
        this.status = "PENDING";
        this.policyCheck = "Valid";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLeaveId() { return leaveId; }
    public void setLeaveId(String leaveId) { this.leaveId = leaveId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPolicyCheck() { return policyCheck; }
    public void setPolicyCheck(String policyCheck) { this.policyCheck = policyCheck; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}