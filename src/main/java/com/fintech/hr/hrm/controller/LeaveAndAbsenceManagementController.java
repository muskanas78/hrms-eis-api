package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.LeaveAndAbsenceManagement;
import com.fintech.hr.hrm.service.LeaveAndAbsenceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/leaves")
public class LeaveAndAbsenceManagementController {

    @Autowired
    private LeaveAndAbsenceManagementService service;

    /**
     * POST /leaves/apply
     */
    @PostMapping("/apply")
    public Map<String, Object> applyLeave(@RequestBody LeaveAndAbsenceManagement leave) {
        LeaveAndAbsenceManagement saved = service.applyLeave(leave);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Leave applied successfully");
        response.put("leaveId", saved.getLeaveId());
        response.put("status", saved.getStatus());
        response.put("policyCheck", saved.getPolicyCheck());
        response.put("details", saved);

        return response;
    }

    /**
     * PATCH /leaves/{leaveId}/approve
     */
    @PatchMapping("/{leaveId}/approve")
    public LeaveAndAbsenceManagement approveLeave(@PathVariable String leaveId) {
        return service.approveLeave(leaveId);
    }

    /**
     * PUT /leaves/{leaveId}
     */
    @PutMapping("/{leaveId}")
    public LeaveAndAbsenceManagement updateLeave(
            @PathVariable String leaveId,
            @RequestBody LeaveAndAbsenceManagement updatedLeave) {
        return service.updateLeave(leaveId, updatedLeave);
    }

    /**
     * DELETE /leaves/{leaveId}
     */
    @DeleteMapping("/{leaveId}")
    public Map<String, String> deleteLeave(@PathVariable String leaveId) {
        service.deleteLeave(leaveId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Leave request deleted successfully");
        response.put("leaveId", leaveId);

        return response;
    }
}