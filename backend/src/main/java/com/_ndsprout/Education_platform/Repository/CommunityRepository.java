package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community , String> {
}
