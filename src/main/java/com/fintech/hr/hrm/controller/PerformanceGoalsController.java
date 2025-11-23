package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.PerformanceGoals;
import com.fintech.hr.hrm.service.PerformanceGoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/performance/goals")
public class PerformanceGoalsController {

    @Autowired
    private PerformanceGoalsService service;

    /**
     * POST /goals
     * Create a performance goal
     */
    @PostMapping
    public Map<String, Object> createGoal(@RequestBody PerformanceGoals goal) {
        PerformanceGoals saved = service.setGoal(goal);

        Map<String, Object> response = new HashMap<>();
        response.put("goalId", saved.getGoalId());
        response.put("status", saved.getStatus());
        response.put("message", "Goal created successfully");
        response.put("details", saved);

        return response;
    }

    /**
     * GET /goals/{employeeId}
     * Fetch all goals for a specific employee
     */
    @GetMapping("/{employeeId}")
    public List<PerformanceGoals> getEmployeeGoals(@PathVariable String employeeId) {
        return service.getGoalsForEmployee(employeeId);
    }

    /**
     * PUT /goals/{goalId}
     * Update a performance goal
     */
    @PutMapping("/{goalId}")
    public Map<String, Object> updateGoal(
            @PathVariable String goalId,
            @RequestBody PerformanceGoals updatedGoal) {

        PerformanceGoals saved = service.updateGoal(goalId, updatedGoal);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Goal updated successfully");
        response.put("goalId", saved.getGoalId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * DELETE /goals/{goalId}
     * Delete a goal
     */
    @DeleteMapping("/{goalId}")
    public Map<String, String> deleteGoal(@PathVariable String goalId) {
        service.deleteGoal(goalId);

        Map<String, String> response = new HashMap<>();
        response.put("goalId", goalId);
        response.put("message", "Goal deleted successfully");

        return response;
    }
}