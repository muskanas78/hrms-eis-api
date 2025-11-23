package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.AttendanceAnomalyReporting;
import com.fintech.hr.hrm.service.AttendanceAnomalyReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/attendance/anomalies")
public class AttendanceAnomalyReportingController {

    @Autowired
    private AttendanceAnomalyReportingService service;

    /**
     * POST /anomalies/report
     * Submit new attendance anomaly
     */
    @PostMapping("/report")
    public Map<String, Object> reportAnomaly(@RequestBody AttendanceAnomalyReporting anomaly) {
        AttendanceAnomalyReporting savedAnomaly = service.reportAnomaly(anomaly);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Anomaly logged");
        response.put("anomalyId", savedAnomaly.getAnomalyId());
        response.put("details", savedAnomaly);

        return response;
    }

    /**
     * GET /anomalies/{id}
     * Retrieve anomaly by MongoDB ID
     */
    @GetMapping("/{id}")
    public AttendanceAnomalyReporting getAnomalyById(@PathVariable String id) {
        return service.getAnomalyById(id);
    }

    /**
     * GET /anomalies/employee/{employeeId}
     * Retrieve anomalies by employee
     */
    @GetMapping("/employee/{employeeId}")
    public List<AttendanceAnomalyReporting> getAnomaliesByEmployee(@PathVariable String employeeId) {
        return service.getAnomaliesByEmployeeId(employeeId);
    }

    /**
     * PATCH /anomalies/{id}/status
     * Update anomaly status
     */
    @PatchMapping("/{id}/status")
    public AttendanceAnomalyReporting updateAnomalyStatus(@PathVariable String id,
                                                          @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");
        return service.updateAnomalyStatus(id, newStatus);
    }
}