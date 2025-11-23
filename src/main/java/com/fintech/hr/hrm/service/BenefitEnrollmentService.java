package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.BenefitEnrollment;
import com.fintech.hr.hrm.repository.BenefitEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BenefitEnrollmentService {

    @Autowired
    private BenefitEnrollmentRepository repository;

    public BenefitEnrollment enroll(BenefitEnrollment enrollment) {
        if (enrollment.getEnrollmentId() == null || enrollment.getEnrollmentId().isEmpty()) {
            enrollment.setEnrollmentId("BEN-" + enrollment.getEmployeeId() + "-" + System.currentTimeMillis());
        }
        enrollment.setStatus("Enrolled");
        enrollment.setCreatedAt(LocalDateTime.now());
        enrollment.setUpdatedAt(LocalDateTime.now());
        return repository.save(enrollment);
    }

    public BenefitEnrollment getEnrollment(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No benefit enrollment found for employeeId: " + employeeId));
    }

    public BenefitEnrollment updateEnrollment(String employeeId, BenefitEnrollment updated) {
        BenefitEnrollment existing = getEnrollment(employeeId);
        existing.setBenefitType(updated.getBenefitType());
        existing.setPlan(updated.getPlan());
        existing.setEnrolledBy(updated.getEnrolledBy());
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    public void deleteEnrollment(String employeeId) {
        BenefitEnrollment existing = getEnrollment(employeeId);
        repository.delete(existing);
    }

    public List<BenefitEnrollment> getAllEnrollments() {
        return repository.findAll();
    }
}