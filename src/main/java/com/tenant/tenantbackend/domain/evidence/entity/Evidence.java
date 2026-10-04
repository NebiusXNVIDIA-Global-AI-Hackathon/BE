package com.tenant.tenantbackend.domain.evidence.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.cases.enums.IssueType;
import com.tenant.tenantbackend.domain.cases.enums.Location;
import com.tenant.tenantbackend.domain.cases.enums.Severity;
import com.tenant.tenantbackend.domain.evidence.enums.AnalysisStatus;
import com.tenant.tenantbackend.domain.evidence.enums.EvidenceMediaType;
import com.tenant.tenantbackend.domain.evidence.enums.Progression;
import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(
        name = "evidences",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "evidence_code"})
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Evidence extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * NULL = 미연결 (Not linked)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    private Case caseEntity;

    /**
     * EV-001 형식, 사용자 단위 순번
     */
    @Column(name = "evidence_code", nullable = false, length = 10)
    private String evidenceCode;

    /**
     * AI 판정 문제명 (Ceiling leak, No heat ...)
     */
    @Column(length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false, length = 10)
    private EvidenceMediaType mediaType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Location location;

    /**
     * location = OTHER 일 때 필수
     */
    @Column(name = "location_detail", length = 100)
    private String locationDetail;

    /**
     * AI 추정 세부 위치
     */
    @Column(name = "sub_location", length = 20)
    private String subLocation;

    @Column(length = 500)
    private String description;

    @Column(name = "description_language", length = 10)
    private String descriptionLanguage;

    @Enumerated(EnumType.STRING)
    @Column(name = "analysis_status", nullable = false, length = 10)
    private AnalysisStatus analysisStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_type", length = 20)
    private IssueType issueType;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Severity severity;

    /**
     * [{en, native}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String reasons;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Progression progression;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "progression_reason", columnDefinition = "jsonb")
    private String progressionReason;

    /**
     * [{label, passed}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "quality_checks", columnDefinition = "jsonb")
    private String qualityChecks;

    @Column(name = "analyzed_at")
    private LocalDateTime analyzedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
