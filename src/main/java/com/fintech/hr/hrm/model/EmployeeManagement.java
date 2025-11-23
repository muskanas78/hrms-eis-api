package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeManagement {

    @Id
    private String id;
    private String employeeId;
    private String fullName;
    private String department;
    private String designation;
    private String dateOfJoining; // format: YYYY-MM-DD
    private String employmentType; // Full-Time, Part-Time, Contract
    private String email;

    public EmployeeManagement() {}

    public EmployeeManagement(String employeeId, String fullName, String department, String designation,
                              String dateOfJoining, String employmentType, String email) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.employmentType = employmentType;
        this.email = email;
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(String dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}