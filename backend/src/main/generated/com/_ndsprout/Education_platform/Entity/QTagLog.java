package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTagLog is a Querydsl query type for TagLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTagLog extends EntityPathBase<TagLog> {

    private static final long serialVersionUID = 484162174L;

    public static final QTagLog tagLog = new QTagLog("tagLog");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final StringPath tagKeyword = createString("tagKeyword");

    public final NumberPath<Long> tagLogId = createNumber("tagLogId", Long.class);

    public final StringPath username = createString("username");

    public QTagLog(String variable) {
        super(TagLog.class, forVariable(variable));
    }

    public QTagLog(Path<? extends TagLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTagLog(PathMetadata metadata) {
        super(TagLog.class, metadata);
    }

}

