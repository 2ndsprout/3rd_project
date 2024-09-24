package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentLog is a Querydsl query type for PaymentLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentLog extends EntityPathBase<PaymentLog> {

    private static final long serialVersionUID = -1186765166L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentLog paymentLog = new QPaymentLog("paymentLog");

    public final DateTimePath<java.time.LocalDateTime> cancelDate = createDateTime("cancelDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> paymentDate = createDateTime("paymentDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> paymentLogId = createNumber("paymentLogId", Long.class);

    public final EnumPath<com._ndsprout.Education_platform.Enum.PaymentType> paymentType = createEnum("paymentType", com._ndsprout.Education_platform.Enum.PaymentType.class);

    public final QSiteUser siteUser;

    public final NumberPath<Integer> usedPoint = createNumber("usedPoint", Integer.class);

    public QPaymentLog(String variable) {
        this(PaymentLog.class, forVariable(variable), INITS);
    }

    public QPaymentLog(Path<? extends PaymentLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentLog(PathMetadata metadata, PathInits inits) {
        this(PaymentLog.class, metadata, inits);
    }

    public QPaymentLog(Class<? extends PaymentLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.siteUser = inits.isInitialized("siteUser") ? new QSiteUser(forProperty("siteUser")) : null;
    }

}

