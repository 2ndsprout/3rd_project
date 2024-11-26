package com._ndsprout.Education_platform.Repository.Custom;

import com._ndsprout.Education_platform.Entity.SiteUser;
import java.util.Optional;

public interface SiteUserRepositoryCustom {

    Optional<SiteUser> findByUsername(String username);
}
