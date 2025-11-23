package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.EmployeeGrievance;
import com.fintech.hr.hrm.service.EmployeeGrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/grievances")
public class EmployeeGrievanceController {

    @Autowired
    private EmployeeGrievanceService service;

    /**
     * POST /grievances
     * Submit new grievance
     */
    @PostMapping
    public Map<String, Object> submit(@RequestBody EmployeeGrievance grievance) {
        EmployeeGrievance saved = service.submitGrievance(grievance);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Grievance submitted successfully");
        response.put("grievanceId", saved.getGrievanceId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /grievances/{grievanceId}
     * Fetch grievance status/details
     */
    @GetMapping("/{grievanceId}")
    public EmployeeGrievance get(@PathVariable String grievanceId) {
        return service.getGrievance(grievanceId);
    }

    /**
     * PUT /grievances/{grievanceId}
     * Update grievance
     */
    @PutMapping("/{grievanceId}")
    public EmployeeGrievance update(
            @PathVariable String grievanceId,
            @RequestBody EmployeeGrievance updatedData) {
        return service.updateGrievance(grievanceId, updatedData);
    }

    /**
     * DELETE /grievances/{grievanceId}
     * Delete grievance
     */
    @DeleteMapping("/{grievanceId}")
    public Map<String, String> delete(@PathVariable String grievanceId) {
        service.deleteGrievance(grievanceId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Grievance deleted successfully");
        response.put("grievanceId", grievanceId);

        return response;
    }
}