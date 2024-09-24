package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor

public class PaymentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentLogId;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser siteUser;

    @CreatedDate
    private LocalDateTime paymentDate;

    @LastModifiedDate
    private LocalDateTime cancelDate;

    private Integer paymentType;

    private Integer usedPoint;

    @Builder
    public PaymentLog(SiteUser siteUser, Integer paymentType, Integer usedPoint){
        this.siteUser =siteUser;
        this.paymentType = paymentType;
        this.usedPoint = usedPoint;
    }
}
