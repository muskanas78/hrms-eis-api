package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "workforce_analytics")
public class WorkforceAnalytics {

    @Id
    private String id;

    private String reportId;                      // e.g., "WF-ANLYT-2025Q3-078"
    private List<String> metrics;                 // ["turnoverRate", "avgHeadcount"]
    private Map<String, Object> filters;          // {"department": ["IT","Finance"], "period": "2025-Q3"}
    private String initiatedBy;                   // "HR-ANALYTICS"

    private Map<String, Object> generatedMetrics; // {"turnoverRate": "5.7%", "avgHeadcount": 268}

    private LocalDateTime generatedAt;
    private LocalDateTime updatedAt;

    public WorkforceAnalytics() {
        this.generatedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // ---- Getters and Setters ----

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }

    public List<String> getMetrics() { return metrics; }
    public void setMetrics(List<String> metrics) { this.metrics = metrics; }

    public Map<String, Object> getFilters() { return filters; }
    public void setFilters(Map<String, Object> filters) { this.filters = filters; }

    public String getInitiatedBy() { return initiatedBy; }
    public void setInitiatedBy(String initiatedBy) { this.initiatedBy = initiatedBy; }

    public Map<String, Object> getGeneratedMetrics() { return generatedMetrics; }
    public void setGeneratedMetrics(Map<String, Object> generatedMetrics) { this.generatedMetrics = generatedMetrics; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}