package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Repository.Custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>, CategoryRepositoryCustom {
}
