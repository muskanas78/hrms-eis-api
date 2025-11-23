package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")  // This tells MongoDB to store in "jobs" collection
public class JobDefinition {

    @Id  // MongoDB will use this as the document ID
    private String id;  // Changed from int to String for MongoDB
    private String title;
    private String department;
    private String description;
    private String requirements;

    // Default constructor (needed for MongoDB)
    public JobDefinition() {
    }

    // Constructor
    public JobDefinition(String id, String title, String department, String description, String requirements) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.description = description;
        this.requirements = requirements;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}