package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.JobDefinition;
import com.fintech.hr.hrm.repository.JobDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDefinitionService {

    @Autowired
    private JobDefinitionRepository repository;

    // Get all jobs from database
    public List<JobDefinition> getAllJobs() {
        return repository.findAll();
    }

    // Get job by ID from database
    public JobDefinition getJobById(String id) {
        return repository.findById(id).orElse(null);
    }

    // Add new job to database
    public JobDefinition addJob(JobDefinition job) {
        return repository.save(job);
    }
}