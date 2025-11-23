package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.AttendanceAndTimesheet;
import com.fintech.hr.hrm.service.AttendanceAndTimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/timesheets")
public class AttendanceAndTimesheetController {

    @Autowired
    private AttendanceAndTimesheetService service;

    /**
     * POST /timesheets/log
     * Log a punch entry
     */
    @PostMapping("/log")
    public Map<String, Object> logAttendance(@RequestBody AttendanceAndTimesheet log) {
        AttendanceAndTimesheet saved = service.logPunch(log);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Punch log recorded successfully");
        response.put("timesheetRef", saved.getTimesheetRef());
        response.put("details", saved);

        return response;
    }

    /**
     * GET /timesheets/{employeeId}?period=2025-09
     */
    @GetMapping("/{employeeId}")
    public List<AttendanceAndTimesheet> getLogsForEmployee(
            @PathVariable String employeeId,
            @RequestParam String period) {

        return service.getLogsByPeriod(employeeId, period);
    }

    /**
     * PUT /timesheets/{id}
     * Update an existing timesheet entry
     */
    @PutMapping("/{id}")
    public AttendanceAndTimesheet updateTimesheet(
            @PathVariable String id,
            @RequestBody AttendanceAndTimesheet updated) {

        return service.updateTimesheet(id, updated);
    }

    /**
     * DELETE /timesheets/{id}
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deleteTimesheet(@PathVariable String id) {
        service.deleteTimesheet(id);

        Map<String, String> res = new HashMap<>();
        res.put("message", "Timesheet entry deleted successfully");
        res.put("timesheetId", id);

        return res;
    }
}