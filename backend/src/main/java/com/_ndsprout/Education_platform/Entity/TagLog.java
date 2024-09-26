package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
//검색한 태그 로그
public class TagLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagLogId;

    private String tagKeyword;

    private String username;

    @CreatedDate
    private LocalDateTime createDate;
}
