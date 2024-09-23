package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.MultiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiKeyRepository extends JpaRepository<String, MultiKey> {
}
