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
//구매강의
public class PaymentLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentLessonId;

    private String title;

    private Integer price;

    private Double discount;

    private Long lessonId;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private  PaymentLog paymentLog;

    @Builder
    public PaymentLesson (String title, Integer price, Double discount, Long lessonId, PaymentLog paymentLog) {
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.lessonId = lessonId;
        this.paymentLog = paymentLog;
    }
}
