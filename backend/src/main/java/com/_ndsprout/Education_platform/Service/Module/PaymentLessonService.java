package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.PaymentLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentLessonService {
    private final PaymentLessonRepository paymentLessonRepository;
}
