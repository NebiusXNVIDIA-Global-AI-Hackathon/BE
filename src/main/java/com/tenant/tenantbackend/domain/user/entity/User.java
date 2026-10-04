package com.tenant.tenantbackend.domain.user.entity;

import com.tenant.tenantbackend.domain.user.enums.Role;
import com.tenant.tenantbackend.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    /**
     * ko / es / en — 모국어 미러 기준 (F0)
     */
    @Column(name = "preferred_language", nullable = false, length = 10)
    private String preferredLanguage;

    /**
     * BUILDING_PATTERN 알림 수신 + 건물 패턴 기여 동의 (F5)
     */
    @Column(name = "building_alert_opt_in", nullable = false)
    private boolean buildingAlertOptIn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;
}
