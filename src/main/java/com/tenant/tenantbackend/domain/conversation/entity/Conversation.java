package com.tenant.tenantbackend.domain.conversation.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * AI 상담 대화 (Assistant)
 */
@Getter
@Builder
@Entity
@Table(name = "conversations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Conversation extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 연결 케이스 (선택)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    private Case caseEntity;
}
