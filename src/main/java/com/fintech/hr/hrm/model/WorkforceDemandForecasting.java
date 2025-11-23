package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "workforce_demand_forecasts")
public class WorkforceDemandForecasting {

    @Id
    private String id;
    private String forecastId;
    private String period;
    private String department;
    private Integer currentHeadcount;  // Changed from int to Integer
    private Integer projectedHeadcount;  // Changed from int to Integer
    private Integer forecastedDemand;  // Changed from int to Integer
    private Double attritionRate;  // Changed from double to Double
    private String budgetConstraint;
    private String complianceRatio;
    private List<String> projectPipeline;
    private String status;
    private String triggeredBy;
    private LocalDateTime forecastDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor
    public WorkforceDemandForecasting() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Full constructor
    public WorkforceDemandForecasting(String id, String forecastId, String period, String department,
                                      Integer currentHeadcount, Integer projectedHeadcount, Integer forecastedDemand,
                                      Double attritionRate, String budgetConstraint, String complianceRatio,
                                      List<String> projectPipeline, String status, String triggeredBy,
                                      LocalDateTime forecastDate) {
        this.id = id;
        this.forecastId = forecastId;
        this.period = period;
        this.department = department;
        this.currentHeadcount = currentHeadcount;
        this.projectedHeadcount = projectedHeadcount;
        this.forecastedDemand = forecastedDemand;
        this.attritionRate = attritionRate;
        this.budgetConstraint = budgetConstraint;
        this.complianceRatio = complianceRatio;
        this.projectPipeline = projectPipeline;
        this.status = status;
        this.triggeredBy = triggeredBy;
        this.forecastDate = forecastDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForecastId() {
        return forecastId;
    }

    public void setForecastId(String forecastId) {
        this.forecastId = forecastId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCurrentHeadcount() {
        return currentHeadcount;
    }

    public void setCurrentHeadcount(Integer currentHeadcount) {
        this.currentHeadcount = currentHeadcount;
    }

    public Integer getProjectedHeadcount() {
        return projectedHeadcount;
    }

    public void setProjectedHeadcount(Integer projectedHeadcount) {
        this.projectedHeadcount = projectedHeadcount;
    }

    public Integer getForecastedDemand() {
        return forecastedDemand;
    }

    public void setForecastedDemand(Integer forecastedDemand) {
        this.forecastedDemand = forecastedDemand;
    }

    public Double getAttritionRate() {
        return attritionRate;
    }

    public void setAttritionRate(Double attritionRate) {
        this.attritionRate = attritionRate;
    }

    public String getBudgetConstraint() {
        return budgetConstraint;
    }

    public void setBudgetConstraint(String budgetConstraint) {
        this.budgetConstraint = budgetConstraint;
    }

    public String getComplianceRatio() {
        return complianceRatio;
    }

    public void setComplianceRatio(String complianceRatio) {
        this.complianceRatio = complianceRatio;
    }

    public List<String> getProjectPipeline() {
        return projectPipeline;
    }

    public void setProjectPipeline(List<String> projectPipeline) {
        this.projectPipeline = projectPipeline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public LocalDateTime getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(LocalDateTime forecastDate) {
        this.forecastDate = forecastDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}