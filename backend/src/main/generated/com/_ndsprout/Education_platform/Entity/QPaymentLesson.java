package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentLesson is a Querydsl query type for PaymentLesson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentLesson extends EntityPathBase<PaymentLesson> {

    private static final long serialVersionUID = 1240956714L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentLesson paymentLesson = new QPaymentLesson("paymentLesson");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Double> discount = createNumber("discount", Double.class);

    public final NumberPath<Long> lessonId = createNumber("lessonId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> paymentLessonId = createNumber("paymentLessonId", Long.class);

    public final QPaymentLog paymentLog;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath title = createString("title");

    public QPaymentLesson(String variable) {
        this(PaymentLesson.class, forVariable(variable), INITS);
    }

    public QPaymentLesson(Path<? extends PaymentLesson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentLesson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentLesson(PathMetadata metadata, PathInits inits) {
        this(PaymentLesson.class, metadata, inits);
    }

    public QPaymentLesson(Class<? extends PaymentLesson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.paymentLog = inits.isInitialized("paymentLog") ? new QPaymentLog(forProperty("paymentLog"), inits.get("paymentLog")) : null;
    }

}

