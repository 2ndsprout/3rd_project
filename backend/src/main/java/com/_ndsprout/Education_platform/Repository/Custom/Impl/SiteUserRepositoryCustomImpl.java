package com._ndsprout.Education_platform.Repository.Custom.Impl;

import com._ndsprout.Education_platform.Entity.QSiteUser;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.Custom.SiteUserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SiteUserRepositoryCustomImpl implements SiteUserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    QSiteUser qSiteUser = QSiteUser.siteUser;

    public Optional<SiteUser> findByUsername(String username){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qSiteUser).where(qSiteUser.username.eq(username)).fetchOne());
    }
}
