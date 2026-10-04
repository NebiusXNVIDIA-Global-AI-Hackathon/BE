package com.tenant.tenantbackend.domain.building.repository;

import com.tenant.tenantbackend.domain.building.entity.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPlaceRepository extends JpaRepository<UserPlace, Long> {

    Optional<UserPlace> findByUserId(Long userId);

    boolean existsByUserId(Long userId);

    List<UserPlace> findAllByBuildingId(Long buildingId);
}
