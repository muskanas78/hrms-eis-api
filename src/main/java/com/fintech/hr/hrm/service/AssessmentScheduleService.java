package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.AssessmentSchedule;
import com.fintech.hr.hrm.repository.AssessmentScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssessmentScheduleService {

    @Autowired
    private AssessmentScheduleRepository repository;

    /**
     * Schedule a new assessment
     */
    public AssessmentSchedule schedule(AssessmentSchedule schedule) {
        if (schedule.getAssessmentId() == null || schedule.getAssessmentId().isEmpty()) {
            schedule.setAssessmentId("ASMT-" + System.currentTimeMillis());
        }
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setUpdatedAt(LocalDateTime.now());
        schedule.setStatus("Scheduled");
        return repository.save(schedule);
    }

    /**
     * Fetch assessment by ID
     */
    public AssessmentSchedule getById(String assessmentId) {
        return repository.findByAssessmentId(assessmentId)
                .orElseThrow(() -> new RuntimeException("No assessment found for ID: " + assessmentId));
    }

    /**
     * Update assessment schedule
     */
    public AssessmentSchedule update(String assessmentId, AssessmentSchedule updated) {
        AssessmentSchedule existing = getById(assessmentId);

        if (updated.getScheduledDate() != null)
            existing.setScheduledDate(updated.getScheduledDate());

        if (updated.getAssessmentType() != null)
            existing.setAssessmentType(updated.getAssessmentType());

        if (updated.getScheduledBy() != null)
            existing.setScheduledBy(updated.getScheduledBy());

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete assessment
     */
    public void delete(String assessmentId) {
        AssessmentSchedule schedule = getById(assessmentId);
        repository.delete(schedule);
    }
}