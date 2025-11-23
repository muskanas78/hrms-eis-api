package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.EmployeeManagement;
import com.fintech.hr.hrm.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService service;

    /**
     * POST /employees → Create employee
     */
    @PostMapping
    public Map<String, Object> createEmployee(@RequestBody EmployeeManagement employee) {
        EmployeeManagement saved = service.createEmployee(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Employee profile created successfully");
        response.put("employeeRefId", saved.getEmployeeId());

        return response;
    }

    /**
     * GET /employees/{id} → Fetch employee
     */
    @GetMapping("/{employeeId}")
    public EmployeeManagement getEmployee(@PathVariable String employeeId) {
        return service.getEmployeeById(employeeId);
    }

    /**
     * PUT /employees/{id} → Update employee
     */
    @PutMapping("/{employeeId}")
    public Map<String, Object> updateEmployee(@PathVariable String employeeId,
                                              @RequestBody EmployeeManagement employee) {
        EmployeeManagement updated = service.updateEmployee(employeeId, employee);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Employee profile updated successfully");
        response.put("employeeRefId", updated.getEmployeeId());

        return response;
    }

    /**
     * DELETE /employees/{id} → Delete employee
     */
    @DeleteMapping("/{employeeId}")
    public Map<String, Object> deleteEmployee(@PathVariable String employeeId) {
        service.deleteEmployee(employeeId);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Employee profile deleted successfully");
        response.put("employeeRefId", employeeId);

        return response;
    }

    /**
     * GET /employees → Fetch all employees
     */
    @GetMapping
    public List<EmployeeManagement> getAllEmployees() {
        return service.getAllEmployees();
    }
}