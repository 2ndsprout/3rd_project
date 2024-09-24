package com._ndsprout.Education_platform.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatParticipants is a Querydsl query type for ChatParticipants
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatParticipants extends EntityPathBase<ChatParticipants> {

    private static final long serialVersionUID = 1122129740L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatParticipants chatParticipants = new QChatParticipants("chatParticipants");

    public final NumberPath<Long> chatParticipantsId = createNumber("chatParticipantsId", Long.class);

    public final QChatRoom chatRoom;

    public final QSiteUser siteUser;

    public QChatParticipants(String variable) {
        this(ChatParticipants.class, forVariable(variable), INITS);
    }

    public QChatParticipants(Path<? extends ChatParticipants> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatParticipants(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatParticipants(PathMetadata metadata, PathInits inits) {
        this(ChatParticipants.class, metadata, inits);
    }

    public QChatParticipants(Class<? extends ChatParticipants> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatRoom = inits.isInitialized("chatRoom") ? new QChatRoom(forProperty("chatRoom")) : null;
        this.siteUser = inits.isInitialized("siteUser") ? new QSiteUser(forProperty("siteUser")) : null;
    }

}

