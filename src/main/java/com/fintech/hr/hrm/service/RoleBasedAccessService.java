package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.RoleBasedAccessAndAuthorization;
import com.fintech.hr.hrm.repository.RoleBasedAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoleBasedAccessService {

    @Autowired
    private RoleBasedAccessRepository repository;

    // Assign a role
    public RoleBasedAccessAndAuthorization assignRole(RoleBasedAccessAndAuthorization roleData) {
        roleData.setGrantedAt(LocalDateTime.now());
        roleData.setRevokedAt(null);
        return repository.save(roleData);
    }

    // Revoke role
    public RoleBasedAccessAndAuthorization revokeRole(String employeeId) {
        RoleBasedAccessAndAuthorization existing = repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No role assigned to employeeId: " + employeeId));

        existing.setRevokedAt(LocalDateTime.now());
        return repository.save(existing);
    }

    // Update role
    public RoleBasedAccessAndAuthorization updateRole(String employeeId, String newRole) {
        RoleBasedAccessAndAuthorization existing = repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No role assigned to employeeId: " + employeeId));

        existing.setRole(newRole);
        existing.setGrantedAt(LocalDateTime.now());
        existing.setRevokedAt(null);
        return repository.save(existing);
    }

    // Delete role record completely
    public void deleteRole(String employeeId) {
        RoleBasedAccessAndAuthorization existing = repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("No role assigned to employeeId: " + employeeId));
        repository.delete(existing);
    }
}