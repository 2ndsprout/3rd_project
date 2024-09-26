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
//강의태그
public class LessonTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @Builder
    public LessonTag (Tag tag, Lesson lesson) {
        this.tag = tag;
        this.lesson = lesson;
    }
}
