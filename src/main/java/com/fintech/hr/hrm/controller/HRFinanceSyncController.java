package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.HRFinanceSync;
import com.fintech.hr.hrm.service.HRFinanceSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/integrations/finance-sync")
public class HRFinanceSyncController {

    @Autowired
    private HRFinanceSyncService service;

    // POST /finance-sync/push
    @PostMapping("/push")
    public HRFinanceSync pushData(@RequestBody HRFinanceSync sync) {
        return service.pushData(sync);
    }

    // GET /finance-sync/status/{batchId}
    @GetMapping("/status/{batchId}")
    public HRFinanceSync getStatus(@PathVariable String batchId) {
        return service.getStatus(batchId);
    }

    // PUT /finance-sync/{batchId}
    @PutMapping("/{batchId}")
    public HRFinanceSync updateSync(@PathVariable String batchId, @RequestBody HRFinanceSync sync) {
        return service.updateSync(batchId, sync);
    }

    // DELETE /finance-sync/{batchId}
    @DeleteMapping("/{batchId}")
    public Map<String, String> deleteSync(@PathVariable String batchId) {
        service.deleteSync(batchId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sync record deleted successfully");
        response.put("batchId", batchId);
        return response;
    }
}