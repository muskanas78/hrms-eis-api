package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.JobDefinition;
import com.fintech.hr.hrm.service.JobDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobDefinitionController {

    @Autowired
    private JobDefinitionService service;

    // GET all jobs
    @GetMapping
    public List<JobDefinition> getAllJobs() {
        return service.getAllJobs();
    }

    // GET job by ID
    @GetMapping("/{id}")
    public JobDefinition getJobById(@PathVariable String id) {  // Changed from int to String
        return service.getJobById(id);
    }

    // POST - Add new job
    @PostMapping
    public JobDefinition addJob(@RequestBody JobDefinition job) {
        return service.addJob(job);
    }
}