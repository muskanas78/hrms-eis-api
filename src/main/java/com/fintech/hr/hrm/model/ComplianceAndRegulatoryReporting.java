package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "compliance_reports")
public class ComplianceAndRegulatoryReporting {

    @Id
    private String id;

    private String reportId;        // e.g., COMP-REP-2025Q3-004
    private String reportType;      // e.g., TaxDeductionSummary
    private String period;          // e.g., 2025-Q3
    private String generatedBy;     // e.g., AUTO-COMPLIANCE
    private String status;          // e.g., Pending, Completed
    private String downloadUrl;     // e.g., /secure/reports/XYZ.pdf

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ComplianceAndRegulatoryReporting() {
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }

    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}