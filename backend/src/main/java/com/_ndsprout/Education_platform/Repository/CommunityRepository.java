package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Community;
import com._ndsprout.Education_platform.Repository.Custom.CommunityRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community , String>, CommunityRepositoryCustom {


}
