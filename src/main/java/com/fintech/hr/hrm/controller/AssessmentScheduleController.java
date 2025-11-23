package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.AssessmentSchedule;
import com.fintech.hr.hrm.service.AssessmentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/assessments")
public class AssessmentScheduleController {

    @Autowired
    private AssessmentScheduleService service;

    /**
     * POST /assessments/schedule
     * Schedule a new assessment
     */
    @PostMapping("/schedule")
    public Map<String, Object> schedule(@RequestBody AssessmentSchedule schedule) {
        AssessmentSchedule saved = service.schedule(schedule);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Assessment scheduled successfully");
        response.put("assessmentId", saved.getAssessmentId());
        response.put("status", saved.getStatus());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /assessments/{id}
     * Fetch assessment by ID
     */
    @GetMapping("/{id}")
    public AssessmentSchedule getAssessment(@PathVariable String id) {
        return service.getById(id);
    }

    /**
     * PUT /assessments/{id}
     * Update assessment schedule details
     */
    @PutMapping("/{id}")
    public AssessmentSchedule updateAssessment(
            @PathVariable String id,
            @RequestBody AssessmentSchedule updated
    ) {
        return service.update(id, updated);
    }

    /**
     * DELETE /assessments/{id}
     * Delete/cancel assessment
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deleteAssessment(@PathVariable String id) {
        service.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Assessment deleted successfully");
        response.put("assessmentId", id);

        return response;
    }
}