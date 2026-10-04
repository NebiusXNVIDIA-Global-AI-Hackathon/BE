package com.tenant.tenantbackend.domain.evidence.repository;

import com.tenant.tenantbackend.domain.evidence.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {

    Optional<Evidence> findByIdAndUserIdAndDeletedAtIsNull(Long id, Long userId);

    List<Evidence> findAllByCaseEntityIdAndDeletedAtIsNull(Long caseId);

    List<Evidence> findAllByIdInAndUserId(List<Long> ids, Long userId);

    long countByUserId(Long userId);
}
