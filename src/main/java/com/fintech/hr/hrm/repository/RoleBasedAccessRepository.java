package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.RoleBasedAccessAndAuthorization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleBasedAccessRepository extends MongoRepository<RoleBasedAccessAndAuthorization, String> {
    Optional<RoleBasedAccessAndAuthorization> findByEmployeeId(String employeeId);
}