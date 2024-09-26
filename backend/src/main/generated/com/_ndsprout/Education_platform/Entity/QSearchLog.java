package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSearchLog is a Querydsl query type for SearchLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSearchLog extends EntityPathBase<SearchLog> {

    private static final long serialVersionUID = 1410783944L;

    public static final QSearchLog searchLog = new QSearchLog("searchLog");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final StringPath searchKeyword = createString("searchKeyword");

    public final NumberPath<Long> searchLogId = createNumber("searchLogId", Long.class);

    public final StringPath username = createString("username");

    public QSearchLog(String variable) {
        super(SearchLog.class, forVariable(variable));
    }

    public QSearchLog(Path<? extends SearchLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSearchLog(PathMetadata metadata) {
        super(SearchLog.class, metadata);
    }

}

