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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private Double grade;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser siteUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @Builder
    public Review(String content,Double grade,SiteUser siteUser, Lesson lesson){
        this.content = content;
        this.grade = grade;
        this.siteUser =siteUser;
        this.lesson = lesson;
    }

}
