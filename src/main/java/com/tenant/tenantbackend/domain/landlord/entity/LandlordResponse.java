package com.tenant.tenantbackend.domain.landlord.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.landlord.enums.ResponseIntent;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 집주인 답장 + AI 해석
 */
@Getter
@Builder
@Entity
@Table(name = "landlord_responses")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LandlordResponse extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    /**
     * 사용자가 붙여넣은 원문
     */
    @Column(name = "raw_text", nullable = false, columnDefinition = "TEXT")
    private String rawText;

    @Column(name = "sender_name", length = 100)
    private String senderName;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ResponseIntent intent;

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
    private String explanation;

    @Column(name = "translation_native", columnDefinition = "TEXT")
    private String translationNative;

    @Column(name = "repair_date")
    private LocalDate repairDate;

    @Column(name = "repair_time", length = 20)
    private String repairTime;

    @Column(name = "repaired_by", length = 100)
    private String repairedBy;

    /**
     * Save changes 시각
     */
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
}
