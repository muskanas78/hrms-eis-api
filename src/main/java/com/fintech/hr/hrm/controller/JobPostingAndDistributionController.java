package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.JobPostingAndDistribution;
import com.fintech.hr.hrm.service.JobPostingAndDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/job-postings")
public class JobPostingAndDistributionController {

    @Autowired
    private JobPostingAndDistributionService service;

    /**
     * POST /job-postings
     * Create a new job posting
     */
    @PostMapping
    public Map<String, Object> createPosting(@RequestBody JobPostingAndDistribution posting) {
        JobPostingAndDistribution saved = service.createPosting(posting);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("postingId", saved.getJobCode());
        response.put("message", "Job posted successfully");
        response.put("details", saved);

        return response;
    }

    /**
     * GET /job-postings/{id}
     * Fetch posting by MongoDB ID
     */
    @GetMapping("/{id}")
    public JobPostingAndDistribution getPostingById(@PathVariable String id) {
        return service.getPostingById(id);
    }

    /**
     * GET /job-postings/code/{jobCode}
     * Fetch posting by jobCode
     */
    @GetMapping("/code/{jobCode}")
    public JobPostingAndDistribution getPostingByJobCode(@PathVariable String jobCode) {
        return service.getPostingByJobCode(jobCode);
    }

    /**
     * GET /job-postings
     * Fetch all postings
     */
    @GetMapping
    public List<JobPostingAndDistribution> getAllPostings() {
        return service.getAllPostings();
    }

    /**
     * PUT /job-postings/{id}
     * Update posting
     */
    @PutMapping("/{id}")
    public JobPostingAndDistribution updatePosting(
            @PathVariable String id,
            @RequestBody JobPostingAndDistribution updatedPosting) {
        return service.updatePosting(id, updatedPosting);
    }

    /**
     * DELETE /job-postings/{id}
     * Delete posting
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deletePosting(@PathVariable String id) {
        service.deletePosting(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Job posting deleted successfully");
        return response;
    }
}