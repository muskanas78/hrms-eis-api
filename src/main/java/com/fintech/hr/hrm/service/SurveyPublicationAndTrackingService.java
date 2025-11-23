package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.SurveyPublicationAndTracking;
import com.fintech.hr.hrm.repository.SurveyPublicationAndTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SurveyPublicationAndTrackingService {

    @Autowired
    private SurveyPublicationAndTrackingRepository repository;

    // POST — publish a survey
    public SurveyPublicationAndTracking publishSurvey(SurveyPublicationAndTracking survey) {
        if (survey.getSurveyId() == null || survey.getSurveyId().isEmpty()) {
            survey.setSurveyId("SURV-" + System.currentTimeMillis());
        }
        survey.setStatus("PUBLISHED");
        survey.setCreatedAt(LocalDateTime.now());
        survey.setUpdatedAt(LocalDateTime.now());
        return repository.save(survey);
    }

    // GET — fetch responses by survey ID
    public SurveyPublicationAndTracking getSurvey(String surveyId) {
        return repository.findBySurveyId(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found: " + surveyId));
    }

    // PUT — update entire survey metadata
    public SurveyPublicationAndTracking updateSurvey(String surveyId, SurveyPublicationAndTracking updated) {
        SurveyPublicationAndTracking existing = getSurvey(surveyId);

        existing.setTitle(updated.getTitle());
        existing.setPublishedBy(updated.getPublishedBy());
        existing.setTargetAudience(updated.getTargetAudience());
        existing.setStatus(updated.getStatus());

        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    // DELETE — remove survey
    public void deleteSurvey(String surveyId) {
        SurveyPublicationAndTracking survey = getSurvey(surveyId);
        repository.delete(survey);
    }
}