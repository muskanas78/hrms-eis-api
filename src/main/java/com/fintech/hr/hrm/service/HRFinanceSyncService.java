package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.HRFinanceSync;
import com.fintech.hr.hrm.repository.HRFinanceSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class HRFinanceSyncService {

    @Autowired
    private HRFinanceSyncRepository repository;

    // POST /finance-sync/push → Push data
    public HRFinanceSync pushData(HRFinanceSync sync) {
        if (sync.getBatchId() == null || sync.getBatchId().isEmpty()) {
            sync.setBatchId("SYNC-HRFIN-" + System.currentTimeMillis());
        }
        sync.setSyncStatus("PENDING");
        sync.setCreatedAt(LocalDateTime.now());
        sync.setUpdatedAt(LocalDateTime.now());
        // Simulate success for demo
        sync.setSyncStatus("SUCCESS");
        sync.setIntegrationRef("FIN-LEDGER-ACK-" + System.currentTimeMillis());
        return repository.save(sync);
    }

    // GET /finance-sync/status/{batchId} → Check status
    public HRFinanceSync getStatus(String batchId) {
        return repository.findByBatchId(batchId)
                .orElseThrow(() -> new RuntimeException("No sync found for batchId: " + batchId));
    }

    // PUT /finance-sync/{batchId} → Update record
    public HRFinanceSync updateSync(String batchId, HRFinanceSync updatedSync) {
        HRFinanceSync existing = getStatus(batchId);
        existing.setRecords(updatedSync.getRecords());
        existing.setTriggeredBy(updatedSync.getTriggeredBy());
        existing.setSyncStatus(updatedSync.getSyncStatus());
        existing.setIntegrationRef(updatedSync.getIntegrationRef());
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    // DELETE /finance-sync/{batchId} → Delete record
    public void deleteSync(String batchId) {
        repository.deleteByBatchId(batchId);
    }
}