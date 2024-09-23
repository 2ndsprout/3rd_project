package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Long , Notification> {
}
