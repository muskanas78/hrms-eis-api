package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.DigitalSignature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DigitalSignatureRepository extends MongoRepository<DigitalSignature, String> {
    Optional<DigitalSignature> findByDocumentId(String documentId);
}