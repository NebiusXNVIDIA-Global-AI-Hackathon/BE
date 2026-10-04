package com.tenant.tenantbackend.domain.notice.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.notice.enums.NoticeType;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

/**
 * 집주인에게 보내는 영어 공식 Notice
 */
@Getter
@Builder
@Entity
@Table(name = "notices")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private NoticeType type;

    /**
     * NYC 규정 인용 영어 본문
     */
    @Column(name = "body_en", nullable = false, columnDefinition = "TEXT")
    private String bodyEn;

    /**
     * 모국어 역번역
     */
    @Column(name = "mirror_native", nullable = false, columnDefinition = "TEXT")
    private String mirrorNative;

    /**
     * [{label, url}]
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false, columnDefinition = "jsonb")
    private String citations;

    /**
     * RPL §223-b {en, native}
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "retaliation_notice", columnDefinition = "jsonb")
    private String retaliationNotice;

    /**
     * SLA 시작 시각
     */
    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(name = "sla_due_at")
    private LocalDateTime slaDueAt;
}
