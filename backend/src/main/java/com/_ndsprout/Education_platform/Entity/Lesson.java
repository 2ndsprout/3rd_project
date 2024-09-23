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
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lessonId;

    @OneToMany
    private List<SiteUser> siteUserList;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String title;

    private String subtitle;

    private String content;

    private int price;

    private double discount;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Section> sectionList;

    @Builder
    public Lesson(SiteUser siteUser,String title, String subtitle,String content,int price){
        this.siteUserList.add(siteUser);
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.price = price;
    }

}
