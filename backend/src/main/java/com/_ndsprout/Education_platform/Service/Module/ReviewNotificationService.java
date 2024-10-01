package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.ReviewNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewNotificationService {
    private final ReviewNotificationRepository reviewNotificationRepository;
}
