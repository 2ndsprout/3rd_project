package com._ndsprout.Education_platform.Repository.Custom.Impl;

import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Entity.QCategory;
import com._ndsprout.Education_platform.Repository.Custom.CategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    QCategory qCategory = QCategory.category;

    public Optional<Category> findByCategoryName(String categoryName){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qCategory).where(qCategory.name.eq(categoryName)).fetchOne());
    }
}
