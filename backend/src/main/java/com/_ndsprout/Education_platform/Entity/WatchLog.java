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
//유저가 마지막에 본 동영상 로그
public class WatchLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchLogId;

    private Long playTime;

    private String videoK;

    private String username;

    @CreatedDate
    private LocalDateTime createDate;

}
