package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.TrainingEnrollment;
import com.fintech.hr.hrm.repository.TrainingEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingEnrollmentService {

    @Autowired
    private TrainingEnrollmentRepository repository;

    /**
     * Enroll an employee in a training session
     */
    public TrainingEnrollment enrollEmployee(TrainingEnrollment enrollment) {
        if (enrollment.getEnrollmentId() == null || enrollment.getEnrollmentId().isEmpty()) {
            enrollment.setEnrollmentId("TRN-ENR-" + enrollment.getEmployeeId() + "-" + enrollment.getTrainingId());
        }
        enrollment.setStatus("Enrolled");
        enrollment.setCreatedAt(LocalDateTime.now());
        enrollment.setUpdatedAt(LocalDateTime.now());
        return repository.save(enrollment);
    }

    /**
     * Fetch enrollment by employeeId
     */
    public List<TrainingEnrollment> getEnrollmentsByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    /**
     * Update enrollment status
     */
    public TrainingEnrollment updateEnrollmentStatus(String enrollmentId, String newStatus) {
        TrainingEnrollment enrollment = repository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("No enrollment found with ID: " + enrollmentId));

        enrollment.setStatus(newStatus);
        enrollment.setUpdatedAt(LocalDateTime.now());
        return repository.save(enrollment);
    }

    /**
     * Delete enrollment
     */
    public void deleteEnrollment(String enrollmentId) {
        TrainingEnrollment enrollment = repository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("No enrollment found with ID: " + enrollmentId));

        repository.delete(enrollment);
    }
}