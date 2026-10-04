package com.tenant.tenantbackend.domain.verification.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.evidence.entity.Evidence;
import com.tenant.tenantbackend.domain.evidence.enums.AnalysisStatus;
import com.tenant.tenantbackend.domain.verification.enums.Verdict;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

/**
 * 수리 전후 비교 검증 (F4)
 */
@Getter
@Builder
@Entity
@Table(name = "repair_verifications")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RepairVerification extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "before_evidence_id", nullable = false)
    private Evidence beforeEvidence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "after_evidence_id", nullable = false)
    private Evidence afterEvidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "analysis_status", nullable = false, length = 10)
    private AnalysisStatus analysisStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Verdict verdict;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String headline;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String summary;

    /**
     * [{label, result, detail}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String checks;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String disclaimer;

    /**
     * Save changes 시각
     */
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
}
