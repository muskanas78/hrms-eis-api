package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.BonusAndIncentive;
import com.fintech.hr.hrm.service.BonusAndIncentiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/bonuses")
public class BonusAndIncentiveController {

    @Autowired
    private BonusAndIncentiveService service;

    /**
     * POST /bonuses/allocate → Allocate bonus
     */
    @PostMapping("/allocate")
    public BonusAndIncentive allocateBonus(@RequestBody BonusAndIncentive bonus) {
        return service.allocateBonus(bonus);
    }

    /**
     * GET /bonuses/{employeeId} → Fetch bonus
     */
    @GetMapping("/{employeeId}")
    public BonusAndIncentive getBonus(@PathVariable String employeeId) {
        return service.getBonusByEmployeeId(employeeId);
    }

    /**
     * PUT /bonuses/{bonusId} → Update bonus
     */
    @PutMapping("/{bonusId}")
    public BonusAndIncentive updateBonus(@PathVariable String bonusId, @RequestBody BonusAndIncentive bonus) {
        return service.updateBonus(bonusId, bonus);
    }

    /**
     * DELETE /bonuses/{bonusId} → Delete bonus
     */
    @DeleteMapping("/{bonusId}")
    public Map<String, String> deleteBonus(@PathVariable String bonusId) {
        service.deleteBonus(bonusId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Bonus deleted successfully");
        response.put("bonusId", bonusId);
        return response;
    }

    /**
     * GET /bonuses → Get all bonuses
     */
    @GetMapping
    public List<BonusAndIncentive> getAllBonuses() {
        return service.getAllBonuses();
    }
}