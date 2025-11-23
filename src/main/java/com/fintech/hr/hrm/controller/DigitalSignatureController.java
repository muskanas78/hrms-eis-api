package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.DigitalSignature;
import com.fintech.hr.hrm.service.DigitalSignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/digital-signatures")
public class DigitalSignatureController {

    @Autowired
    private DigitalSignatureService service;

    /**
     * POST /sign → Submit signature
     */
    @PostMapping("/sign")
    public Map<String, Object> signDocument(@RequestBody DigitalSignature signature) {
        DigitalSignature saved = service.signDocument(signature);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Document signed");
        response.put("signedDocumentId", saved.getDocumentId());
        return response;
    }

    /**
     * GET /sign/{documentId} → Fetch signed document
     */
    @GetMapping("/sign/{documentId}")
    public DigitalSignature getSignedDocument(@PathVariable String documentId) {
        return service.getSignedDocument(documentId);
    }

    /**
     * PUT /sign/{documentId} → Update signature
     */
    @PutMapping("/sign/{documentId}")
    public DigitalSignature updateSignature(
            @PathVariable String documentId,
            @RequestBody Map<String, String> request) {
        String newSignature = request.get("signature");
        return service.updateSignature(documentId, newSignature);
    }

    /**
     * DELETE /sign/{documentId} → Delete signature
     */
    @DeleteMapping("/sign/{documentId}")
    public Map<String, String> deleteSignature(@PathVariable String documentId) {
        service.deleteSignature(documentId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Signature deleted");
        response.put("documentId", documentId);
        return response;
    }
}