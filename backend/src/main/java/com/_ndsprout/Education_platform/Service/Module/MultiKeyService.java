package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.MultiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiKeyService {
    private final MultiKeyRepository multiKeyRepository;
}
