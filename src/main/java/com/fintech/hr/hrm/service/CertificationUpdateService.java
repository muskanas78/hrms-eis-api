package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.CertificationUpdate;
import com.fintech.hr.hrm.repository.CertificationUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CertificationUpdateService {

    @Autowired
    private CertificationUpdateRepository repository;

    /**
     * Add or update certification
     */
    public CertificationUpdate addOrUpdateCertification(CertificationUpdate cert) {
        if (cert.getCertificationId() == null || cert.getCertificationId().isEmpty()) {
            cert.setCertificationId("CERT-" + System.currentTimeMillis());
        }
        cert.setStatus("Updated");
        return repository.save(cert);
    }

    /**
     * Get certifications by employeeId
     */
    public List<CertificationUpdate> getCertificationsByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    /**
     * Update certification details
     */
    public CertificationUpdate updateCertification(String certificationId, CertificationUpdate updatedCert) {
        CertificationUpdate cert = repository.findByCertificationId(certificationId)
                .orElseThrow(() -> new RuntimeException("Certification not found: " + certificationId));

        cert.setCertificationName(updatedCert.getCertificationName());
        cert.setIssueDate(updatedCert.getIssueDate());
        cert.setExpiryDate(updatedCert.getExpiryDate());
        cert.setStatus("Updated");

        return repository.save(cert);
    }

    /**
     * Delete certification
     */
    public void deleteCertification(String certificationId) {
        CertificationUpdate cert = repository.findByCertificationId(certificationId)
                .orElseThrow(() -> new RuntimeException("Certification not found: " + certificationId));
        repository.delete(cert);
    }
}