package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
