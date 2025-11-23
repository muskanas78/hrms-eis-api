package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.FinalSelectionStatus;
import com.fintech.hr.hrm.repository.FinalSelectionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FinalSelectionStatusService {

    @Autowired
    private FinalSelectionStatusRepository repository;

    /**
     * Create or update final selection record
     */
    public FinalSelectionStatus updateStatus(FinalSelectionStatus statusRecord) {
        // Check if record already exists for this candidate
        FinalSelectionStatus existingRecord = repository.findByCandidateId(statusRecord.getCandidateId())
                .orElse(null);

        if (existingRecord != null) {
            // Update existing record
            existingRecord.setStatus(statusRecord.getStatus());
            existingRecord.setApprovedBy(statusRecord.getApprovedBy());
            existingRecord.setRemarks(statusRecord.getRemarks());
            existingRecord.setDecisionDate(LocalDateTime.now());
            existingRecord.setUpdatedAt(LocalDateTime.now());
            return repository.save(existingRecord);
        } else {
            // Create new record
            statusRecord.setDecisionDate(LocalDateTime.now());
            statusRecord.setCreatedAt(LocalDateTime.now());
            statusRecord.setUpdatedAt(LocalDateTime.now());
            return repository.save(statusRecord);
        }
    }

    /**
     * Get final selection status by candidate ID
     */
    public FinalSelectionStatus getStatusByCandidateId(String candidateId) {
        return repository.findByCandidateId(candidateId)
                .orElseThrow(() -> new RuntimeException("No final selection record found for candidateId: " + candidateId));
    }
}