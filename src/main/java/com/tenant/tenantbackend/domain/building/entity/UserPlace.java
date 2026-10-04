package com.tenant.tenantbackend.domain.building.entity;

import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@Table(name = "user_places")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPlace extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 1인 1거주지
     */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    /**
     * Apt 4B
     */
    @Column(nullable = false, length = 20)
    private String unit;

    /**
     * unit에서 파싱 (Apt 4B → 4)
     */
    @Column
    private Integer floor;

    /**
     * unit에서 파싱 (Apt 4B → B)
     */
    @Column(name = "unit_line", length = 10)
    private String unitLine;

    /**
     * false면 MVP 범위 외 안내
     */
    @Column(name = "lease_in_own_name", nullable = false)
    private boolean leaseInOwnName;
}
