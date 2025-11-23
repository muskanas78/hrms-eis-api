package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.ProfileVerification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfileVerificationRepository extends MongoRepository<ProfileVerification, String> {

    Optional<ProfileVerification> findByVerificationId(String verificationId);

    Optional<ProfileVerification> findByEmployeeId(String employeeId);
}