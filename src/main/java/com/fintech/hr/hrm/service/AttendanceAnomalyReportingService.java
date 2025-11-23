package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.AttendanceAnomalyReporting;
import com.fintech.hr.hrm.repository.AttendanceAnomalyReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceAnomalyReportingService {

    @Autowired
    private AttendanceAnomalyReportingRepository repository;

    /**
     * Submit a new anomaly (POST /anomalies/report)
     */
    public AttendanceAnomalyReporting reportAnomaly(AttendanceAnomalyReporting anomaly) {
        // Auto-generate anomalyId
        if (anomaly.getAnomalyId() == null || anomaly.getAnomalyId().isEmpty()) {
            String anomalyId = "ANOM-" + System.currentTimeMillis();
            anomaly.setAnomalyId(anomalyId);
        }

        anomaly.setStatus("Reported");
        anomaly.setCreatedAt(LocalDate.now());
        anomaly.setUpdatedAt(LocalDate.now());

        return repository.save(anomaly);
    }

    /**
     * Get anomaly by MongoDB ID
     */
    public AttendanceAnomalyReporting getAnomalyById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anomaly not found with id: " + id));
    }

    /**
     * Get anomaly by anomalyId
     */
    public AttendanceAnomalyReporting getAnomalyByAnomalyId(String anomalyId) {
        return repository.findByAnomalyId(anomalyId)
                .orElseThrow(() -> new RuntimeException("Anomaly not found with anomalyId: " + anomalyId));
    }

    /**
     * Get all anomalies
     */
    public List<AttendanceAnomalyReporting> getAllAnomalies() {
        return repository.findAll();
    }

    /**
     * Get anomalies by employeeId
     */
    public List<AttendanceAnomalyReporting> getAnomaliesByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    /**
     * Update anomaly status
     */
    public AttendanceAnomalyReporting updateAnomalyStatus(String id, String newStatus) {
        AttendanceAnomalyReporting anomaly = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anomaly not found with id: " + id));

        anomaly.setStatus(newStatus);
        anomaly.setUpdatedAt(LocalDate.now());

        return repository.save(anomaly);
    }
}