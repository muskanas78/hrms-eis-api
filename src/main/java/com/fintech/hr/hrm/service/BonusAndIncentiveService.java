package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.BonusAndIncentive;
import com.fintech.hr.hrm.repository.BonusAndIncentiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BonusAndIncentiveService {

    @Autowired
    private BonusAndIncentiveRepository repository;

    /**
     * Allocate a new bonus
     */
    public BonusAndIncentive allocateBonus(BonusAndIncentive bonus) {
        if (bonus.getBonusId() == null || bonus.getBonusId().isEmpty()) {
            bonus.setBonusId("BON-" + bonus.getEmployeeId() + "-" + System.currentTimeMillis());
        }
        bonus.setStatus("Allocated");
        bonus.setCreatedAt(LocalDateTime.now());
        bonus.setUpdatedAt(LocalDateTime.now());
        return repository.save(bonus);
    }

    /**
     * Fetch bonus by employeeId
     */
    public BonusAndIncentive getBonusByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No bonus found for employeeId: " + employeeId));
    }

    /**
     * Update bonus
     */
    public BonusAndIncentive updateBonus(String bonusId, BonusAndIncentive updatedBonus) {
        BonusAndIncentive existing = repository.findByBonusId(bonusId)
                .orElseThrow(() -> new RuntimeException("No bonus found with bonusId: " + bonusId));

        existing.setBonusType(updatedBonus.getBonusType());
        existing.setAmount(updatedBonus.getAmount());
        existing.setAllocatedBy(updatedBonus.getAllocatedBy());
        existing.setStatus("Updated");
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    /**
     * Delete bonus
     */
    public void deleteBonus(String bonusId) {
        BonusAndIncentive existing = repository.findByBonusId(bonusId)
                .orElseThrow(() -> new RuntimeException("No bonus found with bonusId: " + bonusId));
        repository.delete(existing);
    }

    /**
     * Fetch all bonuses
     */
    public List<BonusAndIncentive> getAllBonuses() {
        return repository.findAll();
    }
}