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
public class CartNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNotificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notification notification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @Builder
    public CartNotification(Notification notification,Cart cart){
        this.notification = notification;
        this.cart = cart;
    }
}
