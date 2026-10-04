package com.tenant.tenantbackend.domain.legal.repository;

import com.tenant.tenantbackend.domain.legal.entity.LegalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegalDocumentRepository extends JpaRepository<LegalDocument, Long> {

    Optional<LegalDocument> findByLabel(String label);
}
