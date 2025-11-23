package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.FinalSelectionStatus;
import com.fintech.hr.hrm.service.FinalSelectionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/selection-status")
public class FinalSelectionStatusController {

    @Autowired
    private FinalSelectionStatusService service;

    /**
     * POST /selection-status
     * Create or update final selection record
     */
    @PostMapping
    public Map<String, Object> updateStatus(@RequestBody FinalSelectionStatus statusRecord) {
        FinalSelectionStatus savedRecord = service.updateStatus(statusRecord);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Candidate selection recorded");
        response.put("candidateId", savedRecord.getCandidateId());
        response.put("selectionDetails", savedRecord);

        return response;
    }

    /**
     * GET /selection-status/{candidateId}
     * Fetch final selection record for a candidate
     */
    @GetMapping("/{candidateId}")
    public FinalSelectionStatus getStatus(@PathVariable String candidateId) {
        return service.getStatusByCandidateId(candidateId);
    }
}