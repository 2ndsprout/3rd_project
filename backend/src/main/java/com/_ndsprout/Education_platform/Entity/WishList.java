package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListId;

    @CreatedDate
    private LocalDateTime createDate;

    @OneToOne
    private SiteUser siteUser;

    @OneToMany
    private List<Lesson> lessonList;

    @Builder
    public WishList(SiteUser siteUser) {
        this.siteUser = siteUser;
    }
}
