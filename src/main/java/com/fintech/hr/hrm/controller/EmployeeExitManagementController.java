package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.EmployeeExitManagement;
import com.fintech.hr.hrm.service.EmployeeExitManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/exit")
public class EmployeeExitManagementController {

    @Autowired
    private EmployeeExitManagementService service;

    /**
     * POST /exit/initiate
     * Start exit process
     */
    @PostMapping("/initiate")
    public Map<String, Object> initiateExit(@RequestBody EmployeeExitManagement request) {
        EmployeeExitManagement saved = service.initiateExit(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exit process initiated successfully");
        response.put("exitId", saved.getExitId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /exit/{employeeId}
     * Fetch exit status by employeeId
     */
    @GetMapping("/{employeeId}")
    public EmployeeExitManagement getExitStatus(@PathVariable String employeeId) {
        return service.getExitByEmployeeId(employeeId);
    }

    /**
     * PUT /exit/{employeeId}
     * Update exit details (date, reason, status)
     */
    @PutMapping("/{employeeId}")
    public EmployeeExitManagement updateExit(
            @PathVariable String employeeId,
            @RequestBody EmployeeExitManagement request) {
        return service.updateExit(employeeId, request);
    }

    /**
     * DELETE /exit/{employeeId}
     * Delete exit record completely
     */
    @DeleteMapping("/{employeeId}")
    public Map<String, String> deleteExit(@PathVariable String employeeId) {
        service.deleteExit(employeeId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee exit record deleted successfully");
        response.put("employeeId", employeeId);

        return response;
    }
}