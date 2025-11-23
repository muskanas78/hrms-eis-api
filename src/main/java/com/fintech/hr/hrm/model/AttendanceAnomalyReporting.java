package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "attendance_anomalies")
public class AttendanceAnomalyReporting {

    @Id
    private String id;
    private String anomalyId;
    private String employeeId;
    private String anomalyType; // e.g., "Missing Punch", "Late Entry"
    private LocalDate date;
    private String status; // "Reported", "Reviewed", "Resolved"
    private String remarks;
    private String reportedBy;

    // Timestamps
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // Default constructor
    public AttendanceAnomalyReporting() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.status = "Reported";
    }

    // Full constructor
    public AttendanceAnomalyReporting(String id, String anomalyId, String employeeId, String anomalyType, LocalDate date,
                                      String status, String remarks, String reportedBy) {
        this.id = id;
        this.anomalyId = anomalyId;
        this.employeeId = employeeId;
        this.anomalyType = anomalyType;
        this.date = date;
        this.status = status != null ? status : "Reported";
        this.remarks = remarks;
        this.reportedBy = reportedBy;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAnomalyId() { return anomalyId; }
    public void setAnomalyId(String anomalyId) { this.anomalyId = anomalyId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getAnomalyType() { return anomalyType; }
    public void setAnomalyType(String anomalyType) { this.anomalyType = anomalyType; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt; }
}