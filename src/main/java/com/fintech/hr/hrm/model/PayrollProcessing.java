package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payroll_batches")
public class PayrollProcessing {

    @Id
    private String id;

    private String payrollBatchId;     // e.g., PAYR-202509-001
    private String cycleMonth;         // e.g., "2025-09"
    private String initiatedBy;        // system or HR user
    private boolean includeContractors;

    private String status;             // processing, completed, failed
    private LocalDateTime initiatedAt;
    private LocalDateTime completedAt;
    private String remarks;

    public PayrollProcessing() {}

    public PayrollProcessing(String payrollBatchId, String cycleMonth, String initiatedBy,
                             boolean includeContractors, String status,
                             LocalDateTime initiatedAt, LocalDateTime completedAt,
                             String remarks) {
        this.payrollBatchId = payrollBatchId;
        this.cycleMonth = cycleMonth;
        this.initiatedBy = initiatedBy;
        this.includeContractors = includeContractors;
        this.status = status;
        this.initiatedAt = initiatedAt;
        this.completedAt = completedAt;
        this.remarks = remarks;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPayrollBatchId() { return payrollBatchId; }
    public void setPayrollBatchId(String payrollBatchId) { this.payrollBatchId = payrollBatchId; }

    public String getCycleMonth() { return cycleMonth; }
    public void setCycleMonth(String cycleMonth) { this.cycleMonth = cycleMonth; }

    public String getInitiatedBy() { return initiatedBy; }
    public void setInitiatedBy(String initiatedBy) { this.initiatedBy = initiatedBy; }

    public boolean isIncludeContractors() { return includeContractors; }
    public void setIncludeContractors(boolean includeContractors) { this.includeContractors = includeContractors; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getInitiatedAt() { return initiatedAt; }
    public void setInitiatedAt(LocalDateTime initiatedAt) { this.initiatedAt = initiatedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}