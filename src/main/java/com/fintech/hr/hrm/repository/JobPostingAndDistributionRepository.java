package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.JobPostingAndDistribution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobPostingAndDistributionRepository extends MongoRepository<JobPostingAndDistribution, String> {

    Optional<JobPostingAndDistribution> findByJobCode(String jobCode);

    List<JobPostingAndDistribution> findByPostedBy(String postedBy);

    List<JobPostingAndDistribution> findByStatus(String status);
}