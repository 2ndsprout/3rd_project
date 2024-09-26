package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWatchLog is a Querydsl query type for WatchLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWatchLog extends EntityPathBase<WatchLog> {

    private static final long serialVersionUID = -1544933335L;

    public static final QWatchLog watchLog = new QWatchLog("watchLog");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> playTime = createNumber("playTime", Long.class);

    public final StringPath username = createString("username");

    public final StringPath videoK = createString("videoK");

    public final NumberPath<Long> watchLogId = createNumber("watchLogId", Long.class);

    public QWatchLog(String variable) {
        super(WatchLog.class, forVariable(variable));
    }

    public QWatchLog(Path<? extends WatchLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWatchLog(PathMetadata metadata) {
        super(WatchLog.class, metadata);
    }

}

