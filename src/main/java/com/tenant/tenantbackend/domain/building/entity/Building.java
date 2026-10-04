package com.tenant.tenantbackend.domain.building.entity;

import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "buildings")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Building extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * NYC Borough-Block-Lot, HPD 연결키
     */
    @Column(nullable = false, unique = true, length = 10)
    private String bbl;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 10)
    private String zip;

    @Column(name = "hpd_synced_at")
    private LocalDateTime hpdSyncedAt;
}
