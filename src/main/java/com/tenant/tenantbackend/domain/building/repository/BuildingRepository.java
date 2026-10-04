package com.tenant.tenantbackend.domain.building.repository;

import com.tenant.tenantbackend.domain.building.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    Optional<Building> findByBbl(String bbl);
}
