package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewNotification is a Querydsl query type for ReviewNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewNotification extends EntityPathBase<ReviewNotification> {

    private static final long serialVersionUID = -1521938537L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewNotification reviewNotification = new QReviewNotification("reviewNotification");

    public final QNotification notification;

    public final QReview review;

    public final NumberPath<Long> reviewNotificationId = createNumber("reviewNotificationId", Long.class);

    public QReviewNotification(String variable) {
        this(ReviewNotification.class, forVariable(variable), INITS);
    }

    public QReviewNotification(Path<? extends ReviewNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewNotification(PathMetadata metadata, PathInits inits) {
        this(ReviewNotification.class, metadata, inits);
    }

    public QReviewNotification(Class<? extends ReviewNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification")) : null;
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

