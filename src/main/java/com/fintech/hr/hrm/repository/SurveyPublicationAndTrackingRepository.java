package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.SurveyPublicationAndTracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyPublicationAndTrackingRepository
        extends MongoRepository<SurveyPublicationAndTracking, String> {

    Optional<SurveyPublicationAndTracking> findBySurveyId(String surveyId);
}