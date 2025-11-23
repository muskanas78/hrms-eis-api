package com.fintech.hr.hrm.repository;

import com.fintech.hr.hrm.model.BonusAndIncentive;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BonusAndIncentiveRepository extends MongoRepository<BonusAndIncentive, String> {

    Optional<BonusAndIncentive> findByEmployeeId(String employeeId);

    Optional<BonusAndIncentive> findByBonusId(String bonusId);

    List<BonusAndIncentive> findByAllocatedBy(String allocatedBy);
}