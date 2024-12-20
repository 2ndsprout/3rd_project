package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.Article;
import com._ndsprout.Education_platform.Entity.Community;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void create(SiteUser siteUser, String title, String content, Community community) {
        articleRepository.save(Article.builder().community(community) //
                        .title(title) //
                        .content(content) //
                        .siteUser(siteUser) //
                .build());
    }
}
