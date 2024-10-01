package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchLogService {
    private final SearchLogRepository searchLogRepository;
}
