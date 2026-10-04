package com.tenant.tenantbackend.domain.legal.entity;

import com.tenant.tenantbackend.domain.legal.enums.Jurisdiction;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * Legal RAG 원문 문서 (F2)
 */
@Getter
@Builder
@Entity
@Table(name = "legal_documents")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LegalDocument extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * NYC HMC §27-2005
     */
    @Column(nullable = false, unique = true, length = 100)
    private String label;

    @Column
    private String title;

    @Column(nullable = false, length = 500)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Jurisdiction jurisdiction;
}
