package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lessonId;

    @OneToMany
    private SiteUser siteUser;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String title;

    private String subtitle;

    private String content;

    private int price;

    private double discount;


}
