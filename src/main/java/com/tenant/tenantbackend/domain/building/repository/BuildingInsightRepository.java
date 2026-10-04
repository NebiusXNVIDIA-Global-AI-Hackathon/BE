package com.tenant.tenantbackend.domain.building.repository;

import com.tenant.tenantbackend.domain.building.entity.BuildingInsight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingInsightRepository extends JpaRepository<BuildingInsight, Long> {

    Optional<BuildingInsight> findByBuildingId(Long buildingId);
}
