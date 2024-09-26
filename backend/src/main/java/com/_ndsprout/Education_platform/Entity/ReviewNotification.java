package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
//수강평알람
public class ReviewNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNotificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notification notification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @Builder
    public ReviewNotification (Notification notification, Review review) {
        this.notification = notification;
        this.review = review;
    }

}
