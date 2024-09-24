package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLessonTag is a Querydsl query type for LessonTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLessonTag extends EntityPathBase<LessonTag> {

    private static final long serialVersionUID = 13157774L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLessonTag lessonTag = new QLessonTag("lessonTag");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final QLesson lesson;

    public final NumberPath<Long> lessonTagId = createNumber("lessonTagId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final QTag tag;

    public QLessonTag(String variable) {
        this(LessonTag.class, forVariable(variable), INITS);
    }

    public QLessonTag(Path<? extends LessonTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLessonTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLessonTag(PathMetadata metadata, PathInits inits) {
        this(LessonTag.class, metadata, inits);
    }

    public QLessonTag(Class<? extends LessonTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lesson = inits.isInitialized("lesson") ? new QLesson(forProperty("lesson")) : null;
        this.tag = inits.isInitialized("tag") ? new QTag(forProperty("tag")) : null;
    }

}

