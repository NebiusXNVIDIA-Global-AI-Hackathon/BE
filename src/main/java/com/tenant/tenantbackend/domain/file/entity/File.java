package com.tenant.tenantbackend.domain.file.entity;

import com.tenant.tenantbackend.domain.evidence.entity.Evidence;
import com.tenant.tenantbackend.domain.file.enums.FileMediaType;
import com.tenant.tenantbackend.domain.user.entity.User;
import com.tenant.tenantbackend.global.common.BaseCreatedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "files")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class File extends BaseCreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 외부 노출 ID (f_8a1c)
     */
    @Column(name = "public_id", nullable = false, unique = true, length = 20)
    private String publicId;

    /**
     * 업로더
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 증거 등록 전 NULL
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evidence_id")
    private Evidence evidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false, length = 10)
    private FileMediaType mediaType;

    @Column(name = "mime_type", nullable = false, length = 50)
    private String mimeType;

    @Column(name = "size_bytes", nullable = false)
    private Long sizeBytes;

    /**
     * 영상·음성만
     */
    @Column(name = "duration_sec")
    private Integer durationSec;

    @Column(name = "storage_key", nullable = false)
    private String storageKey;

    /**
     * 원본 무결성 (Evidence Package)
     */
    @Column(nullable = false, length = 64)
    private String sha256;

    /**
     * EXIF 촬영 시각
     */
    @Column(name = "captured_at")
    private LocalDateTime capturedAt;

    @Column(name = "quality_ok")
    private Boolean qualityOk;
}
