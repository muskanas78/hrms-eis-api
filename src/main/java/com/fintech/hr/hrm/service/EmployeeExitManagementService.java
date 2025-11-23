package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.EmployeeExitManagement;
import com.fintech.hr.hrm.repository.EmployeeExitManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeExitManagementService {

    @Autowired
    private EmployeeExitManagementRepository repository;

    /**
     * Start exit process
     */
    public EmployeeExitManagement initiateExit(EmployeeExitManagement exit) {
        if (exit.getExitId() == null || exit.getExitId().isEmpty()) {
            // EXIT-EMPLOYEEID-TIMESTAMP
            exit.setExitId("EXIT-" + exit.getEmployeeId() + "-" + System.currentTimeMillis());
        }

        exit.setStatus("IN_PROGRESS");
        exit.setCreatedAt(LocalDateTime.now());
        exit.setUpdatedAt(LocalDateTime.now());

        return repository.save(exit);
    }

    /**
     * Get exit status
     */
    public EmployeeExitManagement getExitByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No exit record found for employeeId: " + employeeId));
    }

    /**
     * Update exit details
     */
    public EmployeeExitManagement updateExit(String employeeId, EmployeeExitManagement updatedData) {
        EmployeeExitManagement existing = getExitByEmployeeId(employeeId);

        if (updatedData.getReason() != null) {
            existing.setReason(updatedData.getReason());
        }
        if (updatedData.getExitDate() != null) {
            existing.setExitDate(updatedData.getExitDate());
        }
        if (updatedData.getStatus() != null) {
            existing.setStatus(updatedData.getStatus());
        }

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete exit record
     */
    public void deleteExit(String employeeId) {
        EmployeeExitManagement exit = getExitByEmployeeId(employeeId);
        repository.delete(exit);
    }
}