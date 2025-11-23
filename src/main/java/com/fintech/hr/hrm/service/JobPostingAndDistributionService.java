package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.JobPostingAndDistribution;
import com.fintech.hr.hrm.repository.JobPostingAndDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobPostingAndDistributionService {

    @Autowired
    private JobPostingAndDistributionRepository repository;

    /**
     * Create new job posting
     */
    public JobPostingAndDistribution createPosting(JobPostingAndDistribution posting) {
        if (posting.getJobCode() == null || posting.getJobCode().isEmpty()) {
            posting.setJobCode("JP-" + System.currentTimeMillis());
        }

        posting.setPostedDate(LocalDateTime.now());
        posting.setCreatedAt(LocalDateTime.now());
        posting.setUpdatedAt(LocalDateTime.now());
        posting.setStatus("ACTIVE");

        return repository.save(posting);
    }

    /**
     * Fetch posting by MongoDB ID
     */
    public JobPostingAndDistribution getPostingById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job posting not found with id: " + id));
    }

    /**
     * Fetch posting by jobCode
     */
    public JobPostingAndDistribution getPostingByJobCode(String jobCode) {
        return repository.findByJobCode(jobCode)
                .orElseThrow(() -> new RuntimeException("Job posting not found with jobCode: " + jobCode));
    }

    /**
     * Fetch all postings
     */
    public List<JobPostingAndDistribution> getAllPostings() {
        return repository.findAll();
    }

    /**
     * Fetch postings by status
     */
    public List<JobPostingAndDistribution> getPostingsByStatus(String status) {
        return repository.findByStatus(status);
    }

    /**
     * Update posting details
     */
    public JobPostingAndDistribution updatePosting(String id, JobPostingAndDistribution updatedPosting) {
        JobPostingAndDistribution existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job posting not found with id: " + id));

        if (updatedPosting.getPostingChannels() != null) {
            existing.setPostingChannels(updatedPosting.getPostingChannels());
        }
        if (updatedPosting.getStatus() != null) {
            existing.setStatus(updatedPosting.getStatus());
        }

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete posting
     */
    public void deletePosting(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Job posting not found with id: " + id);
        }
        repository.deleteById(id);
    }
}