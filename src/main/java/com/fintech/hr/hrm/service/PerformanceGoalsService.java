package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.PerformanceGoals;
import com.fintech.hr.hrm.repository.PerformanceGoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PerformanceGoalsService {

    @Autowired
    private PerformanceGoalsRepository repository;

    /**
     * POST – Create new performance goal
     */
    public PerformanceGoals setGoal(PerformanceGoals goal) {
        if (goal.getGoalId() == null || goal.getGoalId().isEmpty()) {
            goal.setGoalId("GOAL-" + goal.getEmployeeId() + "-" + System.currentTimeMillis());
        }
        goal.setStatus("Active");
        goal.setCreatedAt(LocalDateTime.now());
        goal.setUpdatedAt(LocalDateTime.now());

        return repository.save(goal);
    }

    /**
     * GET – Fetch all goals for an employee
     */
    public List<PerformanceGoals> getGoalsForEmployee(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    /**
     * PUT – Update an existing goal
     */
    public PerformanceGoals updateGoal(String goalId, PerformanceGoals updatedGoal) {
        PerformanceGoals existing = repository.findAll().stream()
                .filter(g -> g.getGoalId().equals(goalId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Goal not found: " + goalId));

        if (updatedGoal.getGoal() != null) existing.setGoal(updatedGoal.getGoal());
        if (updatedGoal.getTargetDate() != null) existing.setTargetDate(updatedGoal.getTargetDate());
        if (updatedGoal.getAssignedBy() != null) existing.setAssignedBy(updatedGoal.getAssignedBy());
        if (updatedGoal.getStatus() != null) existing.setStatus(updatedGoal.getStatus());

        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * DELETE – Remove goal
     */
    public void deleteGoal(String goalId) {
        PerformanceGoals existing = repository.findAll().stream()
                .filter(g -> g.getGoalId().equals(goalId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Goal not found: " + goalId));

        repository.delete(existing);
    }
}