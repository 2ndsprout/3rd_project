package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;
}
