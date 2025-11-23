package com.fintech.hr.hrm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "job_postings")
public class JobPostingAndDistribution {

    @Id
    private String id;
    private String jobCode;
    private List<String> postingChannels; // e.g. ["LinkedIn", "Internal"]
    private String postedBy;              // e.g. HR-MANAGER
    private String status;                // e.g. "ACTIVE", "CLOSED"
    private LocalDateTime postedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor
    public JobPostingAndDistribution() {
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.postedDate = LocalDateTime.now();
    }

    // Full constructor
    public JobPostingAndDistribution(String id, String jobCode, List<String> postingChannels,
                                     String postedBy, String status, LocalDateTime postedDate) {
        this.id = id;
        this.jobCode = jobCode;
        this.postingChannels = postingChannels;
        this.postedBy = postedBy;
        this.status = status;
        this.postedDate = postedDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getJobCode() { return jobCode; }
    public void setJobCode(String jobCode) { this.jobCode = jobCode; }

    public List<String> getPostingChannels() { return postingChannels; }
    public void setPostingChannels(List<String> postingChannels) { this.postingChannels = postingChannels; }

    public String getPostedBy() { return postedBy; }
    public void setPostedBy(String postedBy) { this.postedBy = postedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getPostedDate() { return postedDate; }
    public void setPostedDate(LocalDateTime postedDate) { this.postedDate = postedDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}