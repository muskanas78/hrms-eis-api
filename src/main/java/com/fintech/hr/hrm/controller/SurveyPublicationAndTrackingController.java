package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.SurveyPublicationAndTracking;
import com.fintech.hr.hrm.service.SurveyPublicationAndTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyPublicationAndTrackingController {

    @Autowired
    private SurveyPublicationAndTrackingService service;

    /**
     * POST /api/v1/surveys
     * Publish survey
     */
    @PostMapping
    public Map<String, Object> publishSurvey(@RequestBody SurveyPublicationAndTracking survey) {
        SurveyPublicationAndTracking saved = service.publishSurvey(survey);

        Map<String, Object> response = new HashMap<>();
        response.put("surveyId", saved.getSurveyId());
        response.put("status", saved.getStatus());
        response.put("message", "Survey published successfully");

        return response;
    }

    /**
     * GET /api/v1/surveys/{surveyId}
     * Get survey + responses
     */
    @GetMapping("/{surveyId}")
    public SurveyPublicationAndTracking getSurvey(@PathVariable String surveyId) {
        return service.getSurvey(surveyId);
    }

    /**
     * PUT /api/v1/surveys/{surveyId}
     * Update survey metadata
     */
    @PutMapping("/{surveyId}")
    public SurveyPublicationAndTracking updateSurvey(
            @PathVariable String surveyId,
            @RequestBody SurveyPublicationAndTracking updatedSurvey) {

        return service.updateSurvey(surveyId, updatedSurvey);
    }

    /**
     * DELETE /api/v1/surveys/{surveyId}
     * Delete survey
     */
    @DeleteMapping("/{surveyId}")
    public Map<String, String> deleteSurvey(@PathVariable String surveyId) {
        service.deleteSurvey(surveyId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Survey deleted successfully");
        response.put("surveyId", surveyId);

        return response;
    }
}