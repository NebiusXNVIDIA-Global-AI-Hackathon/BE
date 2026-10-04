package com.tenant.tenantbackend.domain.building.repository;

import com.tenant.tenantbackend.domain.building.entity.HpdViolation;
import com.tenant.tenantbackend.domain.building.enums.HpdRecordType;
import com.tenant.tenantbackend.domain.building.enums.HpdStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface HpdViolationRepository extends JpaRepository<HpdViolation, Long> {

    Optional<HpdViolation> findByRecordTypeAndHpdViolationId(HpdRecordType recordType, String hpdViolationId);

    Page<HpdViolation> findAllByBuildingIdAndReportedAtGreaterThanEqual(Long buildingId, LocalDate from, Pageable pageable);

    Page<HpdViolation> findAllByBuildingIdAndRecordTypeAndReportedAtGreaterThanEqual(
            Long buildingId, HpdRecordType recordType, LocalDate from, Pageable pageable);

    long countByBuildingIdAndRecordTypeAndStatus(Long buildingId, HpdRecordType recordType, HpdStatus status);
}
