package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.ComplianceAndRegulatoryReporting;
import com.fintech.hr.hrm.repository.ComplianceAndRegulatoryReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComplianceAndRegulatoryReportingService {

    @Autowired
    private ComplianceAndRegulatoryReportingRepository repository;

    /**
     * Generate a new compliance/regulatory report
     */
    public ComplianceAndRegulatoryReporting generateReport(ComplianceAndRegulatoryReporting request) {

        // Generate unique reportId if missing
        if (request.getReportId() == null || request.getReportId().isEmpty()) {
            String generatedId = "COMP-REP-" + request.getPeriod() + "-" + System.currentTimeMillis();
            request.setReportId(generatedId);
        }

        request.setStatus("Completed");
        request.setDownloadUrl("/secure/reports/" + request.getReportId() + ".pdf");
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());

        return repository.save(request);
    }

    /**
     * Get compliance report by reportId
     */
    public ComplianceAndRegulatoryReporting getReport(String reportId) {
        return repository.findByReportId(reportId)
                .orElseThrow(() -> new RuntimeException("No report found with reportId: " + reportId));
    }

    /**
     * Update an existing report
     */
    public ComplianceAndRegulatoryReporting updateReport(String reportId, ComplianceAndRegulatoryReporting updateRequest) {

        ComplianceAndRegulatoryReporting existing = getReport(reportId);

        if (updateRequest.getReportType() != null)
            existing.setReportType(updateRequest.getReportType());

        if (updateRequest.getPeriod() != null)
            existing.setPeriod(updateRequest.getPeriod());

        if (updateRequest.getGeneratedBy() != null)
            existing.setGeneratedBy(updateRequest.getGeneratedBy());

        if (updateRequest.getStatus() != null)
            existing.setStatus(updateRequest.getStatus());

        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * Delete a report by reportId
     */
    public void deleteReport(String reportId) {
        ComplianceAndRegulatoryReporting report = getReport(reportId);
        repository.delete(report);
    }
}