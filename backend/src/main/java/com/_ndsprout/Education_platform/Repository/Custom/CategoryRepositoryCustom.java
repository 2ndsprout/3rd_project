package com._ndsprout.Education_platform.Repository.Custom;

import com._ndsprout.Education_platform.Entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryCustom {
    Optional<Category> findByCategoryName(String name);
    List<Category> findByParentCategory(Category parentCategory);
}
