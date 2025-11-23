package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.FinalSelectionStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FinalSelectionStatusRepository extends MongoRepository<FinalSelectionStatus, String> {

    Optional<FinalSelectionStatus> findByCandidateId(String candidateId);
}