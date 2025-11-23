package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.CompensationReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface CompensationReviewRepository extends MongoRepository<CompensationReview, String> {

    Optional<CompensationReview> findByEmployeeId(String employeeId);

    List<CompensationReview> findByReviewedBy(String reviewedBy);

    List<CompensationReview> findByStatus(String status);
}