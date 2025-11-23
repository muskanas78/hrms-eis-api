package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.WorkforceAnalytics;
import com.fintech.hr.hrm.repository.WorkforceAnalyticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class WorkforceAnalyticsService {

    @Autowired
    private WorkforceAnalyticsRepository repository;

    /**
     * GET: Fetch metrics (all reports or filtered)
     */
    public List<WorkforceAnalytics> getAllReports() {
        return repository.findAll();
    }

    public WorkforceAnalytics getReport(String reportId) {
        return repository.findByReportId(reportId)
                .orElseThrow(() -> new RuntimeException("No analytics report found with reportId: " + reportId));
    }

    /**
     * POST: Generate a new report
     */
    public WorkforceAnalytics generateReport(WorkforceAnalytics request) {

        if (request.getReportId() == null || request.getReportId().isEmpty()) {
            request.setReportId("WF-ANLYT-" + System.currentTimeMillis());
        }

        // Example metric generation – in real use, replace with your logic
        Map<String, Object> computed = new HashMap<>();
        if (request.getMetrics() != null) {
            for (String metric : request.getMetrics()) {
                if (metric.equalsIgnoreCase("turnoverRate")) {
                    computed.put("turnoverRate", "5.7%");
                }
                if (metric.equalsIgnoreCase("avgHeadcount")) {
                    computed.put("avgHeadcount", 268);
                }
            }
        }

        request.setGeneratedMetrics(computed);
        request.setGeneratedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());

        return repository.save(request);
    }

    /**
     * PUT: Update entire analytics record
     */
    public WorkforceAnalytics updateReport(String reportId, WorkforceAnalytics updated) {
        WorkforceAnalytics existing = getReport(reportId);

        existing.setMetrics(updated.getMetrics());
        existing.setFilters(updated.getFilters());
        existing.setInitiatedBy(updated.getInitiatedBy());
        existing.setGeneratedMetrics(updated.getGeneratedMetrics());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * DELETE: Remove analytics record
     */
    public void deleteReport(String reportId) {
        WorkforceAnalytics existing = getReport(reportId);
        repository.delete(existing);
    }
}