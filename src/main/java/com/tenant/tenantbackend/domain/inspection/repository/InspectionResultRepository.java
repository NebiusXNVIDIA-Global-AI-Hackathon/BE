package com.tenant.tenantbackend.domain.inspection.repository;

import com.tenant.tenantbackend.domain.inspection.entity.InspectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionResultRepository extends JpaRepository<InspectionResult, Long> {
}
