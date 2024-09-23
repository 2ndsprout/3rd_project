package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommunity is a Querydsl query type for Community
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommunity extends EntityPathBase<Community> {

    private static final long serialVersionUID = -1847654859L;

    public static final QCommunity community = new QCommunity("community");

    public final StringPath communityName = createString("communityName");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public QCommunity(String variable) {
        super(Community.class, forVariable(variable));
    }

    public QCommunity(Path<? extends Community> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommunity(PathMetadata metadata) {
        super(Community.class, metadata);
    }

}

