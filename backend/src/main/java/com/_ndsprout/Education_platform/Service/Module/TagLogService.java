package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.TagLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagLogService {
    private final TagLogRepository tagLogRepository;
}
