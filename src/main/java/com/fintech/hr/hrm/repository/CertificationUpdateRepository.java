package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.CertificationUpdate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificationUpdateRepository extends MongoRepository<CertificationUpdate, String> {

    Optional<CertificationUpdate> findByCertificationId(String certificationId);

    List<CertificationUpdate> findByEmployeeId(String employeeId);
}