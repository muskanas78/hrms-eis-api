package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.EmployeeManagement;
import com.fintech.hr.hrm.repository.EmployeeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementService {

    @Autowired
    private EmployeeManagementRepository repository;

    /**
     * Create a new employee
     */
    public EmployeeManagement createEmployee(EmployeeManagement employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId("EMP-" + System.currentTimeMillis());
        }
        return repository.save(employee);
    }

    /**
     * Get employee by employeeId
     */
    public EmployeeManagement getEmployeeById(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + employeeId));
    }

    /**
     * Update existing employee
     */
    public EmployeeManagement updateEmployee(String employeeId, EmployeeManagement updatedEmployee) {
        EmployeeManagement existing = getEmployeeById(employeeId);

        existing.setFullName(updatedEmployee.getFullName());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setDesignation(updatedEmployee.getDesignation());
        existing.setDateOfJoining(updatedEmployee.getDateOfJoining());
        existing.setEmploymentType(updatedEmployee.getEmploymentType());
        existing.setEmail(updatedEmployee.getEmail());

        return repository.save(existing);
    }

    /**
     * Delete employee by employeeId
     */
    public void deleteEmployee(String employeeId) {
        EmployeeManagement existing = getEmployeeById(employeeId);
        repository.delete(existing);
    }

    /**
     * Get all employees
     */
    public List<EmployeeManagement> getAllEmployees() {
        return repository.findAll();
    }
}