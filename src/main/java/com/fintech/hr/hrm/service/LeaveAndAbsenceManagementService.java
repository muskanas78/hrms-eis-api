package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.LeaveAndAbsenceManagement;
import com.fintech.hr.hrm.repository.LeaveAndAbsenceManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LeaveAndAbsenceManagementService {

    @Autowired
    private LeaveAndAbsenceManagementRepository repository;

    /**
     * Apply for leave
     */
    public LeaveAndAbsenceManagement applyLeave(LeaveAndAbsenceManagement leave) {

        if (leave.getLeaveId() == null || leave.getLeaveId().isEmpty()) {
            leave.setLeaveId("LV-" + System.currentTimeMillis() + "-EMP" + leave.getEmployeeId());
        }

        leave.setStatus("PENDING");
        leave.setPolicyCheck("Valid");
        leave.setCreatedAt(LocalDateTime.now());
        leave.setUpdatedAt(LocalDateTime.now());

        return repository.save(leave);
    }

    /**
     * Approve leave
     */
    public LeaveAndAbsenceManagement approveLeave(String leaveId) {
        LeaveAndAbsenceManagement leave = repository.findByLeaveId(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found for leaveId: " + leaveId));

        leave.setStatus("APPROVED");
        leave.setUpdatedAt(LocalDateTime.now());

        return repository.save(leave);
    }

    /**
     * Update leave (PUT)
     */
    public LeaveAndAbsenceManagement updateLeave(String leaveId, LeaveAndAbsenceManagement updatedLeave) {
        LeaveAndAbsenceManagement leave = repository.findByLeaveId(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found for leaveId: " + leaveId));

        leave.setLeaveType(updatedLeave.getLeaveType());
        leave.setStartDate(updatedLeave.getStartDate());
        leave.setEndDate(updatedLeave.getEndDate());
        leave.setReason(updatedLeave.getReason());
        leave.setUpdatedAt(LocalDateTime.now());

        return repository.save(leave);
    }

    /**
     * Delete leave
     */
    public void deleteLeave(String leaveId) {
        LeaveAndAbsenceManagement leave = repository.findByLeaveId(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found: " + leaveId));

        repository.delete(leave);
    }
}