package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.ComplianceAndRegulatoryReporting;
import com.fintech.hr.hrm.service.ComplianceAndRegulatoryReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/compliance/reports")
public class ComplianceAndRegulatoryReportingController {

    @Autowired
    private ComplianceAndRegulatoryReportingService service;

    /**
     * POST /generate
     * Generate a new compliance/regulatory report
     */
    @PostMapping("/generate")
    public Map<String, Object> generateReport(
            @RequestBody ComplianceAndRegulatoryReporting request) {

        ComplianceAndRegulatoryReporting saved = service.generateReport(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Compliance report generated successfully");
        response.put("reportId", saved.getReportId());
        response.put("status", saved.getStatus());
        response.put("downloadUrl", saved.getDownloadUrl());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /reports/{reportId}
     * Fetch compliance report
     */
    @GetMapping("/{reportId}")
    public ComplianceAndRegulatoryReporting getReport(@PathVariable String reportId) {
        return service.getReport(reportId);
    }

    /**
     * PUT /reports/{reportId}
     * Update an existing report
     */
    @PutMapping("/{reportId}")
    public ComplianceAndRegulatoryReporting updateReport(
            @PathVariable String reportId,
            @RequestBody ComplianceAndRegulatoryReporting updateRequest) {

        return service.updateReport(reportId, updateRequest);
    }

    /**
     * DELETE /reports/{reportId}
     * Delete a report
     */
    @DeleteMapping("/{reportId}")
    public Map<String, String> deleteReport(@PathVariable String reportId) {
        service.deleteReport(reportId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Compliance report deleted successfully");
        response.put("reportId", reportId);

        return response;
    }
}