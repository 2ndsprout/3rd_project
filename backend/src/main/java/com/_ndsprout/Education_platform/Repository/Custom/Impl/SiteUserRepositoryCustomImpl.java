package com._ndsprout.Education_platform.Repository.Custom.Impl;

import com._ndsprout.Education_platform.Entity.QSiteUser;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.Custom.SiteUserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SiteUserRepositoryCustomImpl implements SiteUserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    QSiteUser qSiteUser = QSiteUser.siteUser;

    public SiteUser findByUsername(String username){
        return jpaQueryFactory.selectFrom(qSiteUser).where(qSiteUser.username.eq(username)).fetchOne();
    }
}
