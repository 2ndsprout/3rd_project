package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<String, Category> {
}
