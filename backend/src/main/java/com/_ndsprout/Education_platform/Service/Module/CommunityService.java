package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.Community;
import com._ndsprout.Education_platform.Repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;

    public void create(String CommunityName,String communityName) {
        communityRepository.save(Community.builder().communityName(communityName).build());
    }

    public Community get(String communityName) {
      return  communityRepository.findByCommunityName(communityName);
    }
}
