package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.CandidateSubmission;
import com.fintech.hr.hrm.service.CandidateSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateSubmissionController {

    @Autowired
    private CandidateSubmissionService service;

    // POST /api/v1/candidates
    @PostMapping
    public Map<String, Object> submitCandidate(@RequestBody CandidateSubmission candidate) {
        CandidateSubmission saved = service.submitCandidate(candidate);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Candidate submitted");
        response.put("candidateRef", saved.getCandidateId());
        response.put("details", saved);
        return response;
    }

    // GET /api/v1/candidates/{id}
    @GetMapping("/{id}")
    public CandidateSubmission getCandidateById(@PathVariable String id) {
        return service.getCandidateById(id);
    }

    // GET /api/v1/candidates/candidate/{candidateId}
    @GetMapping("/candidate/{candidateId}")
    public CandidateSubmission getCandidateByCandidateId(@PathVariable String candidateId) {
        return service.getCandidateByCandidateId(candidateId);
    }

    // GET /api/v1/candidates
    @GetMapping
    public List<CandidateSubmission> getAllCandidates() {
        return service.getAllCandidates();
    }

    // GET /api/v1/candidates/job/{jobCode}
    @GetMapping("/job/{jobCode}")
    public List<CandidateSubmission> getCandidatesByJobCode(@PathVariable String jobCode) {
        return service.getCandidatesByJobCode(jobCode);
    }

    // GET /api/v1/candidates/status/{status}
    @GetMapping("/status/{status}")
    public List<CandidateSubmission> getCandidatesByStatus(@PathVariable String status) {
        return service.getCandidatesByStatus(status);
    }

    // PATCH /api/v1/candidates/{id}/status
    @PatchMapping("/{id}/status")
    public CandidateSubmission updateCandidateStatus(@PathVariable String id, @RequestBody Map<String, String> update) {
        String newStatus = update.get("status");
        return service.updateCandidateStatus(id, newStatus);
    }

    // PUT /api/v1/candidates/{id}
    @PutMapping("/{id}")
    public CandidateSubmission updateCandidate(@PathVariable String id, @RequestBody CandidateSubmission updated) {
        return service.updateCandidate(id, updated);
    }

    // DELETE /api/v1/candidates/{id}
    @DeleteMapping("/{id}")
    public Map<String, String> deleteCandidate(@PathVariable String id) {
        service.deleteCandidate(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Candidate deleted successfully");
        response.put("id", id);
        return response;
    }
}