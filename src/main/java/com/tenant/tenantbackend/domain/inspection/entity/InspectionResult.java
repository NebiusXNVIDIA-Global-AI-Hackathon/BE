package com.tenant.tenantbackend.domain.inspection.entity;

import com.tenant.tenantbackend.domain.building.entity.Building;
import com.tenant.tenantbackend.domain.cases.enums.IssueType;
import com.tenant.tenantbackend.domain.evidence.entity.Evidence;
import com.tenant.tenantbackend.domain.inspection.enums.InspectionOutcome;
import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Guided Inspection 결과
 */
@Getter
@Builder
@Entity
@Table(name = "inspection_results")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class InspectionResult extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    /**
     * 점검 당시 패턴 이슈 유형
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "issue_type", nullable = false, length = 20)
    private IssueType issueType;

    /**
     * [{order, symptoms}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String results;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InspectionOutcome outcome;

    /**
     * FOUND_ISSUE → Add evidence 한 경우
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evidence_id")
    private Evidence evidence;
}
