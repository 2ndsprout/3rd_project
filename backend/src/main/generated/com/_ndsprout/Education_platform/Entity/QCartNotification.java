package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartNotification is a Querydsl query type for CartNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartNotification extends EntityPathBase<CartNotification> {

    private static final long serialVersionUID = 1729586271L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartNotification cartNotification = new QCartNotification("cartNotification");

    public final QCart cart;

    public final NumberPath<Long> cartNotificationId = createNumber("cartNotificationId", Long.class);

    public final QNotification notification;

    public QCartNotification(String variable) {
        this(CartNotification.class, forVariable(variable), INITS);
    }

    public QCartNotification(Path<? extends CartNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCartNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCartNotification(PathMetadata metadata, PathInits inits) {
        this(CartNotification.class, metadata, inits);
    }

    public QCartNotification(Class<? extends CartNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new QCart(forProperty("cart"), inits.get("cart")) : null;
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
    }

}

