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
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
//수강생
public class LessonUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonUserId;

    @OneToOne
    private Lesson lesson;

    @OneToOne
    private SiteUser siteUser;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @Builder
    public LessonUser(Lesson lesson, SiteUser siteUser){
        this.lesson = lesson;
        this.siteUser = siteUser;
    }
}
