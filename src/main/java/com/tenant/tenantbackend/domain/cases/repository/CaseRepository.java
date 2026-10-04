package com.tenant.tenantbackend.domain.cases.repository;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {

    Optional<Case> findByIdAndUserIdAndDeletedAtIsNull(Long id, Long userId);

    List<Case> findAllByUserIdAndDeletedAtIsNull(Long userId);

    long countByUserId(Long userId);
}
