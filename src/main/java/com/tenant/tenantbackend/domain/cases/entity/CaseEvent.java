package com.tenant.tenantbackend.domain.cases.entity;

import com.tenant.tenantbackend.domain.cases.enums.CaseEventRefType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "case_events")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CaseEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    /**
     * 타임라인 이벤트 (CASE_CREATED, EVIDENCE_ADDED ...)
     */
    @Column(nullable = false, length = 30)
    private String type;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    /**
     * {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "ref_type", length = 20)
    private CaseEventRefType refType;

    @Column(name = "ref_id")
    private Long refId;
}
