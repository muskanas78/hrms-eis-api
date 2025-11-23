package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.CandidateSubmission;
import com.fintech.hr.hrm.repository.CandidateSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidateSubmissionService {

    @Autowired
    private CandidateSubmissionRepository repository;

    // Submit a new candidate
    public CandidateSubmission submitCandidate(CandidateSubmission candidate) {
        if (candidate.getCandidateId() == null || candidate.getCandidateId().isEmpty()) {
            candidate.setCandidateId("CAND-" + System.currentTimeMillis());
        }
        candidate.setSubmittedDate(LocalDateTime.now());
        candidate.setStatus("SUBMITTED");
        candidate.setCreatedAt(LocalDateTime.now());
        candidate.setUpdatedAt(LocalDateTime.now());
        return repository.save(candidate);
    }

    // Fetch candidate by MongoDB ID
    public CandidateSubmission getCandidateById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found with id: " + id));
    }

    // Fetch candidate by candidateId
    public CandidateSubmission getCandidateByCandidateId(String candidateId) {
        return repository.findByCandidateId(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found with candidateId: " + candidateId));
    }

    // Get all candidates
    public List<CandidateSubmission> getAllCandidates() {
        return repository.findAll();
    }

    // Get by jobCode
    public List<CandidateSubmission> getCandidatesByJobCode(String jobCode) {
        return repository.findByJobCode(jobCode);
    }

    // Get by status
    public List<CandidateSubmission> getCandidatesByStatus(String status) {
        return repository.findByStatus(status);
    }

    // Update candidate status
    public CandidateSubmission updateCandidateStatus(String id, String newStatus) {
        CandidateSubmission candidate = getCandidateById(id);
        candidate.setStatus(newStatus);
        candidate.setUpdatedAt(LocalDateTime.now());
        return repository.save(candidate);
    }

    // Update candidate details
    public CandidateSubmission updateCandidate(String id, CandidateSubmission updated) {
        CandidateSubmission existing = getCandidateById(id);

        if (updated.getFullName() != null) existing.setFullName(updated.getFullName());
        if (updated.getEmail() != null) existing.setEmail(updated.getEmail());
        if (updated.getPhone() != null) existing.setPhone(updated.getPhone());
        if (updated.getResumeUrl() != null) existing.setResumeUrl(updated.getResumeUrl());
        if (updated.getJobCode() != null) existing.setJobCode(updated.getJobCode());

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    // Delete candidate
    public void deleteCandidate(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Candidate not found with id: " + id);
        }
        repository.deleteById(id);
    }
}