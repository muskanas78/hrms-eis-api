package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.ProfileVerification;
import com.fintech.hr.hrm.repository.ProfileVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileVerificationService {

    @Autowired
    private ProfileVerificationRepository repository;

    // POST /verify — Submit new profile for verification
    public ProfileVerification submitVerification(ProfileVerification verification) {
        if (verification.getVerificationId() == null || verification.getVerificationId().isEmpty()) {
            verification.setVerificationId("VER-" + System.currentTimeMillis());
        }

        verification.setStatus("Pending");
        verification.setMessage("Verification in progress");
        verification.setCreatedAt(LocalDateTime.now());
        verification.setUpdatedAt(LocalDateTime.now());

        return repository.save(verification);
    }

    // GET /verify/{id}
    public ProfileVerification getVerificationById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile verification not found with id: " + id));
    }

    // GET /verify/verificationId/{verificationId}
    public ProfileVerification getVerificationByVerificationId(String verificationId) {
        return repository.findByVerificationId(verificationId)
                .orElseThrow(() -> new RuntimeException("Verification not found with ID: " + verificationId));
    }

    // PATCH update status
    public ProfileVerification updateStatus(String id, String newStatus, String message) {
        ProfileVerification verification = getVerificationById(id);
        verification.setStatus(newStatus);
        verification.setMessage(message);
        verification.setUpdatedAt(LocalDateTime.now());
        return repository.save(verification);
    }

    // GET all
    public List<ProfileVerification> getAllVerifications() {
        return repository.findAll();
    }
}