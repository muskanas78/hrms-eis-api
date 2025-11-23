package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.PerformanceReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PerformanceReviewRepository extends MongoRepository<PerformanceReview, String> {

    Optional<PerformanceReview> findByEmployeeId(String employeeId);
    Optional<PerformanceReview> findByReviewId(String reviewId);
    List<PerformanceReview> findByStatus(String status);
}