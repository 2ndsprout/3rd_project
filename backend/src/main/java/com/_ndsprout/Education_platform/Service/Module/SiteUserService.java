package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;

}
