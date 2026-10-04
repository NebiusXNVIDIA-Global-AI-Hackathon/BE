package com.tenant.tenantbackend.domain.building.entity;

import com.tenant.tenantbackend.domain.building.enums.HpdRecordType;
import com.tenant.tenantbackend.domain.building.enums.HpdStatus;
import com.tenant.tenantbackend.domain.building.enums.ViolationClass;
import com.tenant.tenantbackend.domain.cases.enums.IssueType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * HPD 민원(COMPLAINT)·위반(VIOLATION) 기록
 */
@Getter
@Builder
@Entity
@Table(
        name = "hpd_violations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"record_type", "hpd_violation_id"})
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class HpdViolation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false, length = 20)
    private HpdRecordType recordType;

    @Column(name = "hpd_violation_id", nullable = false, length = 20)
    private String hpdViolationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_type", nullable = false, length = 20)
    private IssueType issueType;

    /**
     * HPD 원본 카테고리
     */
    @Column(nullable = false, length = 100)
    private String category;

    /**
     * VIOLATION일 때만
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "violation_class", length = 2)
    private ViolationClass violationClass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private HpdStatus status;

    @Column(name = "reported_at", nullable = false)
    private LocalDate reportedAt;

    @Column(name = "closed_at")
    private LocalDate closedAt;
}
