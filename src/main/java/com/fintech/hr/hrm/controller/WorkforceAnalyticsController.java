package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.WorkforceAnalytics;
import com.fintech.hr.hrm.service.WorkforceAnalyticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/analytics/workforce")
public class WorkforceAnalyticsController {

    @Autowired
    private WorkforceAnalyticsService service;

    /**
     * GET /analytics/workforce
     * Fetch all workforce analytics reports
     */
    @GetMapping
    public List<WorkforceAnalytics> getAllReports() {
        return service.getAllReports();
    }

    /**
     * GET /analytics/workforce/{reportId}
     * Fetch specific report by reportId
     */
    @GetMapping("/{reportId}")
    public WorkforceAnalytics getReport(@PathVariable String reportId) {
        return service.getReport(reportId);
    }

    /**
     * POST /analytics/workforce
     * Generate a new workforce analytics report
     */
    @PostMapping
    public WorkforceAnalytics generateReport(@RequestBody WorkforceAnalytics analytics) {
        return service.generateReport(analytics);
    }

    /**
     * PUT /analytics/workforce/{reportId}
     * Update full analytics record
     */
    @PutMapping("/{reportId}")
    public WorkforceAnalytics updateReport(
            @PathVariable String reportId,
            @RequestBody WorkforceAnalytics analytics) {
        return service.updateReport(reportId, analytics);
    }

    /**
     * DELETE /analytics/workforce/{reportId}
     * Delete analytics report
     */
    @DeleteMapping("/{reportId}")
    public Map<String, String> deleteReport(@PathVariable String reportId) {

        service.deleteReport(reportId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Workforce analytics report deleted successfully");
        response.put("reportId", reportId);

        return response;
    }
}