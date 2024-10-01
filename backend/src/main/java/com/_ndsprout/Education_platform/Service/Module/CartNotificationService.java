package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.CartNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartNotificationService {
    private final CartNotificationRepository cartNotificationRepository;
}
