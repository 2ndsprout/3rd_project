package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLesson is a Querydsl query type for Lesson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLesson extends EntityPathBase<Lesson> {

    private static final long serialVersionUID = 259218028L;

    public static final QLesson lesson = new QLesson("lesson");


    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Double> discount = createNumber("discount", Double.class);


    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> lessonId = createNumber("lessonId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);


    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<Section, QSection> sectionList = this.<Section, QSection>createList("sectionList", Section.class, QSection.class, PathInits.DIRECT2);

    public final ListPath<SiteUser, QSiteUser> siteUserList = this.<SiteUser, QSiteUser>createList("siteUserList", SiteUser.class, QSiteUser.class, PathInits.DIRECT2);


    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QSiteUser siteUser;


    public final StringPath subtitle = createString("subtitle");

    public final StringPath title = createString("title");

    public final QSiteUser siteUser;



    public QLesson(String variable) {
        super(Lesson.class, forVariable(variable));
    }

    public QLesson(Path<? extends Lesson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLesson(PathMetadata metadata) {
        super(Lesson.class, metadata);
    }

}

