package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.LessonUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonUserRepository extends JpaRepository<Long, LessonUser> {
}
