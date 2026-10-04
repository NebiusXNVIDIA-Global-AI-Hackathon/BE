package com.tenant.tenantbackend.domain.cases.entity;

import com.tenant.tenantbackend.domain.building.entity.Building;
import com.tenant.tenantbackend.domain.cases.enums.*;
import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "cases")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Case extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * C-004 형식
     */
    @Column(name = "case_number", nullable = false, unique = true, length = 20)
    private String caseNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 이웃 실시간 이슈 집계용
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    /**
     * 생성 시점 호수 스냅샷
     */
    @Column(length = 20)
    private String unit;

    @Column(nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_type", nullable = false, length = 20)
    private IssueType issueType;

    @Enumerated(EnumType.STRING)
    @Column(name = "case_type", nullable = false, length = 30)
    private CaseType caseType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Location location;

    @Column(name = "sub_location", length = 20)
    private String subLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CaseStage stage;

    /**
     * Discovered date
     */
    @Column(name = "first_observed_at")
    private LocalDate firstObservedAt;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    /**
     * 케이스 생성 시 선택 증거 분석 {findings, recommended_type, alternatives}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "ai_analysis", columnDefinition = "jsonb")
    private String aiAnalysis;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String summary;

    @Column(name = "summary_updated_at")
    private LocalDateTime summaryUpdatedAt;

    @Column(name = "next_action_type", length = 30)
    private String nextActionType;

    /**
     * {title, description, cta}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "next_action", columnDefinition = "jsonb")
    private String nextAction;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
