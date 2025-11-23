package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.CertificationUpdate;
import com.fintech.hr.hrm.service.CertificationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/certifications")
public class CertificationUpdateController {

    @Autowired
    private CertificationUpdateService service;

    /**
     * POST /update → Add/update certification
     */
    @PostMapping("/update")
    public Map<String, Object> addOrUpdate(@RequestBody CertificationUpdate cert) {
        CertificationUpdate saved = service.addOrUpdateCertification(cert);

        Map<String, Object> response = new HashMap<>();
        response.put("certificationId", saved.getCertificationId());
        response.put("status", saved.getStatus());

        return response;
    }

    /**
     * GET /certifications/{employeeId} → Fetch certifications
     */
    @GetMapping("/{employeeId}")
    public List<CertificationUpdate> getByEmployee(@PathVariable String employeeId) {
        return service.getCertificationsByEmployeeId(employeeId);
    }

    /**
     * PUT /certifications/{certificationId} → Update certification
     */
    @PutMapping("/{certificationId}")
    public Map<String, Object> updateCertification(
            @PathVariable String certificationId,
            @RequestBody CertificationUpdate updatedCert) {

        CertificationUpdate updated = service.updateCertification(certificationId, updatedCert);

        Map<String, Object> response = new HashMap<>();
        response.put("certificationId", updated.getCertificationId());
        response.put("status", updated.getStatus());

        return response;
    }

    /**
     * DELETE /certifications/{certificationId} → Delete certification
     */
    @DeleteMapping("/{certificationId}")
    public Map<String, String> deleteCertification(@PathVariable String certificationId) {
        service.deleteCertification(certificationId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Certification deleted successfully");
        response.put("certificationId", certificationId);

        return response;
    }
}