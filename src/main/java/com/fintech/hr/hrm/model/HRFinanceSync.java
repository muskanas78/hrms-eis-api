package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "hr_finance_sync")
public class HRFinanceSync {

    @Id
    private String id;
    private String batchId;
    private List<Map<String, Object>> records; // e.g., [{"employeeId": "EMP-1072","salaryRevision":120000}]
    private String triggeredBy;
    private String syncStatus; // SUCCESS / FAILED / PENDING
    private String integrationRef; // reference from Finance/ERP system
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public HRFinanceSync() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }

    public List<Map<String, Object>> getRecords() { return records; }
    public void setRecords(List<Map<String, Object>> records) { this.records = records; }

    public String getTriggeredBy() { return triggeredBy; }
    public void setTriggeredBy(String triggeredBy) { this.triggeredBy = triggeredBy; }

    public String getSyncStatus() { return syncStatus; }
    public void setSyncStatus(String syncStatus) { this.syncStatus = syncStatus; }

    public String getIntegrationRef() { return integrationRef; }
    public void setIntegrationRef(String integrationRef) { this.integrationRef = integrationRef; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}