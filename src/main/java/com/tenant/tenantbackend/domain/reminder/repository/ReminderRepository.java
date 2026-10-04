package com.tenant.tenantbackend.domain.reminder.repository;

import com.tenant.tenantbackend.domain.reminder.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    Optional<Reminder> findByIdAndCaseEntityId(Long id, Long caseId);

    List<Reminder> findAllByFireAtBeforeAndFiredAtIsNullAndCanceledAtIsNull(LocalDateTime now);
}
