package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLessonUser is a Querydsl query type for LessonUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLessonUser extends EntityPathBase<LessonUser> {

    private static final long serialVersionUID = 407938135L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLessonUser lessonUser = new QLessonUser("lessonUser");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLesson lesson;

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final QSiteUser siteUser;

    public QLessonUser(String variable) {
        this(LessonUser.class, forVariable(variable), INITS);
    }

    public QLessonUser(Path<? extends LessonUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLessonUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLessonUser(PathMetadata metadata, PathInits inits) {
        this(LessonUser.class, metadata, inits);
    }

    public QLessonUser(Class<? extends LessonUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lesson = inits.isInitialized("lesson") ? new QLesson(forProperty("lesson")) : null;
        this.siteUser = inits.isInitialized("siteUser") ? new QSiteUser(forProperty("siteUser")) : null;
    }

}

