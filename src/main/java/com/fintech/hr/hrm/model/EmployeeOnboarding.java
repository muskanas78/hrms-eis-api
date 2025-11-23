package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "employee_onboardings")
public class EmployeeOnboarding {

    @Id
    private String id;
    private String onboardingId;
    private String employeeId;
    private String startDate;
    private String assignedMentor;
    private String department;
    private String status; // e.g., "PENDING", "IN_PROGRESS", "COMPLETED", "ON_HOLD"
    private List<String> completedTasks; // e.g., ["Document Verification", "Orientation"]
    private List<String> pendingTasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmployeeOnboarding() {
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public EmployeeOnboarding(String onboardingId, String employeeId, String startDate, String assignedMentor,
                              String department, String status, List<String> completedTasks, List<String> pendingTasks) {
        this.onboardingId = onboardingId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.assignedMentor = assignedMentor;
        this.department = department;
        this.status = status;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getOnboardingId() { return onboardingId; }
    public void setOnboardingId(String onboardingId) { this.onboardingId = onboardingId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getAssignedMentor() { return assignedMentor; }
    public void setAssignedMentor(String assignedMentor) { this.assignedMentor = assignedMentor; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getCompletedTasks() { return completedTasks; }
    public void setCompletedTasks(List<String> completedTasks) { this.completedTasks = completedTasks; }

    public List<String> getPendingTasks() { return pendingTasks; }
    public void setPendingTasks(List<String> pendingTasks) { this.pendingTasks = pendingTasks; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}