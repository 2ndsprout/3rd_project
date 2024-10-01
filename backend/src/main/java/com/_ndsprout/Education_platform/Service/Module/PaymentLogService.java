package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.PaymentLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentLogService {
    private final PaymentLogRepository paymentLogRepository;
}
