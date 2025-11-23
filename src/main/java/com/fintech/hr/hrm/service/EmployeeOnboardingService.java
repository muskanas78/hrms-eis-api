package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.EmployeeOnboarding;
import com.fintech.hr.hrm.repository.EmployeeOnboardingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeOnboardingService {

    @Autowired
    private EmployeeOnboardingRepository repository;

    /**
     * Start a new onboarding process
     */
    public EmployeeOnboarding startOnboarding(EmployeeOnboarding onboarding) {
        if (onboarding.getOnboardingId() == null || onboarding.getOnboardingId().isEmpty()) {
            onboarding.setOnboardingId("ONB-" + System.currentTimeMillis());
        }
        onboarding.setStatus("IN_PROGRESS");
        onboarding.setCreatedAt(LocalDateTime.now());
        onboarding.setUpdatedAt(LocalDateTime.now());
        return repository.save(onboarding);
    }

    /**
     * Get onboarding details by employeeId
     */
    public EmployeeOnboarding getOnboardingByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No onboarding found for employeeId: " + employeeId));
    }

    /**
     * Get all onboardings
     */
    public List<EmployeeOnboarding> getAllOnboardings() {
        return repository.findAll();
    }

    /**
     * Update onboarding progress (add completed task)
     */
    public EmployeeOnboarding updateProgress(String employeeId, String completedTask) {
        EmployeeOnboarding onboarding = getOnboardingByEmployeeId(employeeId);

        if (!onboarding.getCompletedTasks().contains(completedTask)) {
            onboarding.getCompletedTasks().add(completedTask);
            onboarding.getPendingTasks().remove(completedTask);
        }

        if (onboarding.getPendingTasks().isEmpty()) {
            onboarding.setStatus("COMPLETED");
        }

        onboarding.setUpdatedAt(LocalDateTime.now());
        return repository.save(onboarding);
    }

    /**
     * Update onboarding status manually (e.g., put on hold)
     */
    public EmployeeOnboarding updateStatus(String employeeId, String newStatus) {
        EmployeeOnboarding onboarding = getOnboardingByEmployeeId(employeeId);
        onboarding.setStatus(newStatus);
        onboarding.setUpdatedAt(LocalDateTime.now());
        return repository.save(onboarding);
    }

    /**
     * Delete onboarding record
     */
    public void deleteOnboarding(String employeeId) {
        EmployeeOnboarding onboarding = getOnboardingByEmployeeId(employeeId);
        repository.delete(onboarding);
    }
}