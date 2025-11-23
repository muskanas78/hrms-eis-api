package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.DigitalSignature;
import com.fintech.hr.hrm.repository.DigitalSignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DigitalSignatureService {

    @Autowired
    private DigitalSignatureRepository repository;

    /**
     * Submit a new digital signature
     */
    public DigitalSignature signDocument(DigitalSignature signature) {
        signature.setCreatedAt(LocalDateTime.now());
        signature.setUpdatedAt(LocalDateTime.now());
        return repository.save(signature);
    }

    /**
     * Fetch signed document by documentId
     */
    public DigitalSignature getSignedDocument(String documentId) {
        return repository.findByDocumentId(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found: " + documentId));
    }

    /**
     * Update signature
     */
    public DigitalSignature updateSignature(String documentId, String newSignature) {
        DigitalSignature existing = getSignedDocument(documentId);
        existing.setSignature(newSignature);
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    /**
     * Delete signature record
     */
    public void deleteSignature(String documentId) {
        DigitalSignature existing = getSignedDocument(documentId);
        repository.delete(existing);
    }
}