package com.tenant.tenantbackend.domain.conversation.repository;

import com.tenant.tenantbackend.domain.conversation.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByIdAndUserId(Long id, Long userId);

    List<Conversation> findAllByUserIdOrderByCreatedAtDesc(Long userId);
}
