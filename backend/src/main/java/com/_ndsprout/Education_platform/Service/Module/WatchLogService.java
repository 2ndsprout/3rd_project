package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.WatchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WatchLogService {
    private final WatchLogRepository watchLogRepository;
}
