package com.tenant.tenantbackend.domain.building.entity;

import com.tenant.tenantbackend.domain.building.enums.InsightDataSource;
import com.tenant.tenantbackend.domain.building.enums.LandlordRisk;
import com.tenant.tenantbackend.domain.building.enums.PatternConfidence;
import com.tenant.tenantbackend.domain.building.enums.PatternScope;
import com.tenant.tenantbackend.domain.cases.enums.IssueType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 건물 패턴(F5)·집주인 응답 위험도(F6) 배치 계산 결과
 */
@Getter
@Builder
@Entity
@Table(name = "building_insights")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BuildingInsight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false, unique = true)
    private Building building;

    // F5 건물 패턴

    @Enumerated(EnumType.STRING)
    @Column(name = "pattern_issue_type", length = 20)
    private IssueType patternIssueType;

    /**
     * related reports 수, 3건 이상일 때만 패턴 노출
     */
    @Column(name = "pattern_count")
    private Integer patternCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "pattern_scope", length = 30)
    private PatternScope patternScope;

    @Column(name = "pattern_floor_from")
    private Integer patternFloorFrom;

    @Column(name = "pattern_floor_to")
    private Integer patternFloorTo;

    @Column(name = "pattern_window_days")
    private Integer patternWindowDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "pattern_confidence", length = 10)
    private PatternConfidence patternConfidence;

    /**
     * {by_floor, by_issue} 익명 집계
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "pattern_breakdown", columnDefinition = "jsonb")
    private String patternBreakdown;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "possible_cause", columnDefinition = "jsonb")
    private String possibleCause;

    /**
     * [{en, native}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "guided_inspection", columnDefinition = "jsonb")
    private String guidedInspection;

    // F6 집주인 응답 위험도

    @Column(name = "avg_days_to_resolve")
    private Integer avgDaysToResolve;

    @Column(name = "median_response_days")
    private Integer medianResponseDays;

    @Column(name = "unanswered_ratio", precision = 4, scale = 3)
    private BigDecimal unansweredRatio;

    @Enumerated(EnumType.STRING)
    @Column(name = "landlord_risk", length = 10)
    private LandlordRisk landlordRisk;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_source", nullable = false, length = 20)
    private InsightDataSource dataSource;

    @Column(name = "computed_at", nullable = false)
    private LocalDateTime computedAt;
}
