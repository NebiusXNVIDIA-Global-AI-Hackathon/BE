package com.tenant.tenantbackend.domain.notice.repository;

import com.tenant.tenantbackend.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    Optional<Notice> findByIdAndCaseEntityId(Long id, Long caseId);

    List<Notice> findAllByCaseEntityIdOrderByCreatedAtAsc(Long caseId);

    List<Notice> findAllBySlaDueAtBefore(LocalDateTime now);
}
