package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
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
//파일저장
public class FileSystem {

    @Id
    private String k;

    private String v;

    private Long playTime; // 나중에 변경

    private String name;

    private Integer height;

    private Integer width;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @Builder
    public FileSystem(String key, String value, Long playTime,String name,Integer height,Integer width){
        this.k = key;
        this.v = value;
        this.playTime = playTime;
        this.name = name;
        this.height = height;
        this.width = width;
    }
}
