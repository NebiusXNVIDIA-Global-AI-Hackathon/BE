package com.tenant.tenantbackend.domain.cases.repository;

import com.tenant.tenantbackend.domain.cases.entity.CaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseEventRepository extends JpaRepository<CaseEvent, Long> {

    List<CaseEvent> findAllByCaseEntityIdOrderByOccurredAtAsc(Long caseId);
}
