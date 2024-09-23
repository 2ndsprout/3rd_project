package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSection is a Querydsl query type for Section
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSection extends EntityPathBase<Section> {

    private static final long serialVersionUID = 1348630577L;

    public static final QSection section = new QSection("section");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> sectionId = createNumber("sectionId", Long.class);

    public final StringPath subtitle = createString("subtitle");

    public QSection(String variable) {
        super(Section.class, forVariable(variable));
    }

    public QSection(Path<? extends Section> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSection(PathMetadata metadata) {
        super(Section.class, metadata);
    }

}

