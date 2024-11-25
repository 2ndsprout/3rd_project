package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.Custom.SiteUserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser ,String>, SiteUserRepositoryCustom {

    void deleteUsername (String username);
}
