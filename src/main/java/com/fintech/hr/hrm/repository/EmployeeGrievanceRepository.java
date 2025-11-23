package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.EmployeeGrievance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeGrievanceRepository extends MongoRepository<EmployeeGrievance, String> {

    Optional<EmployeeGrievance> findByGrievanceId(String grievanceId);

}