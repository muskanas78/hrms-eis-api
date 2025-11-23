package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.PayrollProcessing;
import com.fintech.hr.hrm.repository.PayrollProcessingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PayrollProcessingService {

    @Autowired
    private PayrollProcessingRepository repository;

    /**
     * Trigger payroll generation for a given month
     */
    public PayrollProcessing runPayroll(PayrollProcessing request) {

        String batchId = "PAYR-" + request.getCycleMonth() + "-" + UUID.randomUUID()
                .toString().substring(0, 4).toUpperCase();

        request.setPayrollBatchId(batchId);
        request.setInitiatedAt(LocalDateTime.now());
        request.setStatus("processing");

        return repository.save(request);
    }

    /**
     * Fetch payroll details for a given month
     */
    public PayrollProcessing getPayrollByMonth(String month) {
        return repository.findByCycleMonth(month)
                .orElseThrow(() -> new RuntimeException("Payroll not found for month: " + month));
    }

    /**
     * Update payroll status or remarks
     */
    public PayrollProcessing updatePayroll(String month, PayrollProcessing update) {
        PayrollProcessing existing = getPayrollByMonth(month);

        if (update.getStatus() != null) {
            existing.setStatus(update.getStatus());
        }

        if (update.getRemarks() != null) {
            existing.setRemarks(update.getRemarks());
        }

        if ("completed".equalsIgnoreCase(update.getStatus())) {
            existing.setCompletedAt(LocalDateTime.now());
        }

        return repository.save(existing);
    }

    /**
     * Delete payroll batch by month
     */
    public void deletePayroll(String month) {
        repository.deleteByCycleMonth(month);
    }
}