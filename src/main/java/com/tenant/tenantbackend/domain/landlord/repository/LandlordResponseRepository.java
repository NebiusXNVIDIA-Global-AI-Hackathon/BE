package com.tenant.tenantbackend.domain.landlord.repository;

import com.tenant.tenantbackend.domain.landlord.entity.LandlordResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LandlordResponseRepository extends JpaRepository<LandlordResponse, Long> {

    Optional<LandlordResponse> findByIdAndCaseEntityId(Long id, Long caseId);

    List<LandlordResponse> findAllByCaseEntityIdOrderByReceivedAtAsc(Long caseId);
}
