package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.RoleBasedAccessAndAuthorization;
import com.fintech.hr.hrm.service.RoleBasedAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/access-control")
public class RoleBasedAccessController {

    @Autowired
    private RoleBasedAccessService service;

    /**
     * POST /access-control/assign-role → Assign role
     */
    @PostMapping("/assign-role")
    public RoleBasedAccessAndAuthorization assignRole(@RequestBody RoleBasedAccessAndAuthorization roleData) {
        return service.assignRole(roleData);
    }

    /**
     * DELETE /access-control/revoke/{employeeId} → Revoke role
     */
    @DeleteMapping("/revoke/{employeeId}")
    public RoleBasedAccessAndAuthorization revokeRole(@PathVariable String employeeId) {
        return service.revokeRole(employeeId);
    }

    /**
     * PUT /access-control/update-role → Update role
     */
    @PutMapping("/update-role")
    public RoleBasedAccessAndAuthorization updateRole(@RequestBody Map<String, String> request) {
        String employeeId = request.get("employeeId");
        String newRole = request.get("role");
        return service.updateRole(employeeId, newRole);
    }

    /**
     * DELETE /access-control/delete/{employeeId} → Delete role record
     */
    @DeleteMapping("/delete/{employeeId}")
    public Map<String, String> deleteRole(@PathVariable String employeeId) {
        service.deleteRole(employeeId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Role record deleted successfully for employeeId: " + employeeId);
        return response;
    }
}