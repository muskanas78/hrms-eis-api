package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.EmployeeGrievance;
import com.fintech.hr.hrm.repository.EmployeeGrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeGrievanceService {

    @Autowired
    private EmployeeGrievanceRepository repository;

    /**
     * Submit a grievance
     */
    public EmployeeGrievance submitGrievance(EmployeeGrievance grievance) {

        if (grievance.getGrievanceId() == null || grievance.getGrievanceId().isEmpty()) {
            grievance.setGrievanceId("GRV-" + grievance.getEmployeeId() + "-" + System.currentTimeMillis());
        }

        grievance.setStatus("UNDER_REVIEW");
        grievance.setSubmittedAt(LocalDateTime.now());
        grievance.setUpdatedAt(LocalDateTime.now());

        return repository.save(grievance);
    }

    /**
     * Fetch grievance by grievanceId
     */
    public EmployeeGrievance getGrievance(String grievanceId) {
        return repository.findByGrievanceId(grievanceId)
                .orElseThrow(() -> new RuntimeException("No grievance found with ID: " + grievanceId));
    }

    /**
     * Update grievance (e.g., change issue or update status)
     */
    public EmployeeGrievance updateGrievance(String grievanceId, EmployeeGrievance updatedData) {
        EmployeeGrievance existing = getGrievance(grievanceId);

        if (updatedData.getIssue() != null) {
            existing.setIssue(updatedData.getIssue());
        }

        if (updatedData.getStatus() != null) {
            existing.setStatus(updatedData.getStatus());
        }

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete grievance
     */
    public void deleteGrievance(String grievanceId) {
        EmployeeGrievance grievance = getGrievance(grievanceId);
        repository.delete(grievance);
    }
}