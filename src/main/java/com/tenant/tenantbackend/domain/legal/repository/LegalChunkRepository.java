package com.tenant.tenantbackend.domain.legal.repository;

import com.tenant.tenantbackend.domain.legal.entity.LegalChunk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegalChunkRepository extends JpaRepository<LegalChunk, Long> {

    /**
     * 코사인 거리 기준 유사 청크 검색 (embedding: "[0.1,0.2,...]" 문자열)
     */
    @Query(value = """
            SELECT * FROM legal_chunks
            ORDER BY embedding <=> CAST(:embedding AS vector)
            LIMIT :limit
            """, nativeQuery = true)
    List<LegalChunk> findNearest(@Param("embedding") String embedding, @Param("limit") int limit);
}
