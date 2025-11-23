package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.AttendanceAndTimesheet;
import com.fintech.hr.hrm.repository.AttendanceAndTimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class AttendanceAndTimesheetService {

    @Autowired
    private AttendanceAndTimesheetRepository repository;

    /**
     * Create/log a punch entry
     */
    public AttendanceAndTimesheet logPunch(AttendanceAndTimesheet log) {
        String ref = "TS-" + log.getEmployeeId() + "-" +
                log.getTimestamp().toLocalDate() + "-" + log.getPunchType();

        log.setTimesheetRef(ref);
        log.setCreatedAt(LocalDateTime.now());
        log.setUpdatedAt(LocalDateTime.now());

        return repository.save(log);
    }

    /**
     * Fetch monthly logs for an employee: period = YYYY-MM
     */
    public List<AttendanceAndTimesheet> getLogsByPeriod(String employeeId, String period) {
        YearMonth yearMonth = YearMonth.parse(period); // ex: 2025-09

        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59);

        return repository.findByEmployeeIdAndTimestampBetween(employeeId, start, end);
    }

    /**
     * Update a timesheet record by ID
     */
    public AttendanceAndTimesheet updateTimesheet(String id, AttendanceAndTimesheet updated) {
        AttendanceAndTimesheet existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheet not found for ID: " + id));

        if (updated.getPunchType() != null) existing.setPunchType(updated.getPunchType());
        if (updated.getTimestamp() != null) existing.setTimestamp(updated.getTimestamp());
        if (updated.getSourceDevice() != null) existing.setSourceDevice(updated.getSourceDevice());

        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete timesheet record
     */
    public void deleteTimesheet(String id) {
        AttendanceAndTimesheet existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheet not found for ID: " + id));
        repository.delete(existing);
    }
}