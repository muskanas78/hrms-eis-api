package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.EmployeeFeedback;
import com.fintech.hr.hrm.repository.EmployeeFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeFeedbackService {

    @Autowired
    private EmployeeFeedbackRepository repository;

    /**
     * Create feedback
     */
    public EmployeeFeedback submitFeedback(EmployeeFeedback feedback) {
        if (feedback.getFeedbackId() == null || feedback.getFeedbackId().isEmpty()) {
            feedback.setFeedbackId("FDBK-" + System.currentTimeMillis());
        }
        feedback.setSubmittedAt(LocalDateTime.now());
        feedback.setUpdatedAt(LocalDateTime.now());
        feedback.setStatus("Recorded");

        return repository.save(feedback);
    }

    /**
     * Fetch feedback list for employee
     */
    public List<EmployeeFeedback> getFeedbackByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    /**
     * Update existing feedback
     */
    public EmployeeFeedback updateFeedback(String feedbackId, EmployeeFeedback updateRequest) {
        EmployeeFeedback existing = repository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found: " + feedbackId));

        if (updateRequest.getFeedbackType() != null)
            existing.setFeedbackType(updateRequest.getFeedbackType());

        if (updateRequest.getComments() != null)
            existing.setComments(updateRequest.getComments());

        existing.setStatus("Updated");
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * Delete feedback
     */
    public void deleteFeedback(String feedbackId) {
        repository.deleteById(feedbackId);
    }
}