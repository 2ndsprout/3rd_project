package com._ndsprout.Education_platform.Repository.Custom;

import com._ndsprout.Education_platform.Entity.Community;

public interface CommunityRepositoryCustom {

    public Community findByCommunityName(String communityName);
}
