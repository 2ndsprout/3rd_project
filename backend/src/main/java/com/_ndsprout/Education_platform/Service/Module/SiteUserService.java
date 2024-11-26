package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;

    @Transactional
    public SiteUser get(String value){
        return this.siteUserRepository.findById(value).orElse(null);
    }
//    public Boolean Signup()

}
