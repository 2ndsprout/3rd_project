package com._ndsprout.Education_platform.Repository.Custom;

import com._ndsprout.Education_platform.Entity.SiteUser;

public interface SiteUserRepositoryCustom {

    SiteUser findByUsername(String username);
}
