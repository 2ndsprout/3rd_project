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
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
//강의
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lessonId;

    @OneToMany
    private List<SiteUser> siteUserList = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String title;

    private String subtitle;

    private String content;

    private Integer price;

    private Double discount;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Section> sectionList = new ArrayList<>();

    @Builder
    public Lesson(SiteUser siteUser,String title, String subtitle,String content,Integer price){
        this.siteUserList.add(siteUser);
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.price = price;
    }

}
