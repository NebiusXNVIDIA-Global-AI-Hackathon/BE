package com.tenant.tenantbackend.domain.reminder.entity;

import com.tenant.tenantbackend.domain.cases.entity.Case;
import com.tenant.tenantbackend.domain.reminder.enums.ReminderType;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "reminders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Reminder extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ReminderType type;

    @Column(name = "fire_at", nullable = false)
    private LocalDateTime fireAt;

    @Column(name = "fired_at")
    private LocalDateTime firedAt;

    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;
}
