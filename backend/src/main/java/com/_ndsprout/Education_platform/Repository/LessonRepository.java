package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Long, Lesson> {
}
