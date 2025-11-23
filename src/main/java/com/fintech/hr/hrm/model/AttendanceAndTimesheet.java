package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "attendance_timesheets")
public class AttendanceAndTimesheet {

    @Id
    private String id;

    private String timesheetRef;
    private String employeeId;
    private String punchType; // IN or OUT
    private LocalDateTime timestamp;
    private String sourceDevice; // e.g., biometric reader

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AttendanceAndTimesheet() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AttendanceAndTimesheet(String employeeId, String punchType,
                                  LocalDateTime timestamp, String sourceDevice) {
        this.employeeId = employeeId;
        this.punchType = punchType;
        this.timestamp = timestamp;
        this.sourceDevice = sourceDevice;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTimesheetRef() { return timesheetRef; }
    public void setTimesheetRef(String timesheetRef) { this.timesheetRef = timesheetRef; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getPunchType() { return punchType; }
    public void setPunchType(String punchType) { this.punchType = punchType; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getSourceDevice() { return sourceDevice; }
    public void setSourceDevice(String sourceDevice) { this.sourceDevice = sourceDevice; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}