package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileSystem is a Querydsl query type for FileSystem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileSystem extends EntityPathBase<FileSystem> {

    private static final long serialVersionUID = -993314305L;

    public static final QFileSystem fileSystem = new QFileSystem("fileSystem");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final StringPath k = createString("k");

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> playTime = createNumber("playTime", Integer.class);

    public final StringPath v = createString("v");

    public final NumberPath<Integer> width = createNumber("width", Integer.class);

    public QFileSystem(String variable) {
        super(FileSystem.class, forVariable(variable));
    }

    public QFileSystem(Path<? extends FileSystem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileSystem(PathMetadata metadata) {
        super(FileSystem.class, metadata);
    }

}

