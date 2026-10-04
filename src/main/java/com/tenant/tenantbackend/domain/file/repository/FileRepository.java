package com.tenant.tenantbackend.domain.file.repository;

import com.tenant.tenantbackend.domain.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findByPublicId(String publicId);

    List<File> findAllByPublicIdIn(List<String> publicIds);

    List<File> findAllByEvidenceId(Long evidenceId);
}
