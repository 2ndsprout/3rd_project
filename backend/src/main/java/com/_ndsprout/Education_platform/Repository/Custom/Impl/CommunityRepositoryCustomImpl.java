package com._ndsprout.Education_platform.Repository.Custom.Impl;

import com._ndsprout.Education_platform.Entity.Community;
import com._ndsprout.Education_platform.Entity.QCommunity;
import com._ndsprout.Education_platform.Repository.Custom.CommunityRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityRepositoryCustomImpl implements CommunityRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    QCommunity qCommunity = QCommunity.community;
    @Override
    public Community findByCommunityName(String communityName) {
        return jpaQueryFactory.selectFrom(qCommunity).where(qCommunity.communityName.eq(communityName)).fetchOne();
    }
}
