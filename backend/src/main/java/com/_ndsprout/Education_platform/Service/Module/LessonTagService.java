package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonTagService {
    private final LessonRepository lessonRepository;
}
