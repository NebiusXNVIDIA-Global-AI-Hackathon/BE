package com.tenant.tenantbackend.domain.verification.repository;

import com.tenant.tenantbackend.domain.verification.entity.RepairVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepairVerificationRepository extends JpaRepository<RepairVerification, Long> {

    Optional<RepairVerification> findByIdAndCaseEntityId(Long id, Long caseId);
}
