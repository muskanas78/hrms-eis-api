package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.CandidateSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateSubmissionRepository extends MongoRepository<CandidateSubmission, String> {

    Optional<CandidateSubmission> findByCandidateId(String candidateId);

    List<CandidateSubmission> findByJobCode(String jobCode);

    List<CandidateSubmission> findByStatus(String status);

    List<CandidateSubmission> findBySubmittedBy(String submittedBy);

    List<CandidateSubmission> findByFullNameContainingIgnoreCase(String fullName);
}