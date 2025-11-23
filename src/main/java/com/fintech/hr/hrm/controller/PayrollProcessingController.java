package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.PayrollProcessing;
import com.fintech.hr.hrm.service.PayrollProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/payrolls")
public class PayrollProcessingController {

    @Autowired
    private PayrollProcessingService service;

    /**
     * POST /payrolls/run
     * Trigger payroll processing
     */
    @PostMapping("/run")
    public Map<String, Object> runPayroll(@RequestBody PayrollProcessing request) {

        PayrollProcessing saved = service.runPayroll(request);

        Map<String, Object> response = new HashMap<>();
        response.put("payrollBatchId", saved.getPayrollBatchId());
        response.put("status", saved.getStatus());
        response.put("cycleMonth", saved.getCycleMonth());
        response.put("initiatedAt", saved.getInitiatedAt());

        return response;
    }

    /**
     * GET /payrolls/{month}
     * Retrieve payroll batch for a month
     */
    @GetMapping("/{month}")
    public PayrollProcessing getPayroll(@PathVariable String month) {
        return service.getPayrollByMonth(month);
    }

    /**
     * PUT /payrolls/{month}
     * Update payroll status or remarks
     */
    @PutMapping("/{month}")
    public PayrollProcessing updatePayroll(
            @PathVariable String month,
            @RequestBody PayrollProcessing update) {
        return service.updatePayroll(month, update);
    }

    /**
     * DELETE /payrolls/{month}
     * Delete payroll batch
     */
    @DeleteMapping("/{month}")
    public Map<String, String> deletePayroll(@PathVariable String month) {

        service.deletePayroll(month);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Payroll batch deleted successfully");
        response.put("month", month);

        return response;
    }
}