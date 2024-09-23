package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<Long, ChatMessage> {
}
