package com._ndsprout.Education_platform.Entity;

import com._ndsprout.Education_platform.Enum.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
//유저
public class SiteUser {

    @Id
    @Column(length = 24, unique = true)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String password;

    @Email
    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 15, unique = true)
    private String nickname;

    @Column(columnDefinition = "TEXT")
    private String introduce;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String phoneNumber;

    private Integer point;

    private UserRole userRole;

@Builder
    public SiteUser(String username,String password,String email, String nickname,String phoneNumber,Integer point, UserRole userRole){
    this.username = username;
    this.password = password;
    this.email = email;
    this.nickname = nickname;
    this.phoneNumber = phoneNumber;
    this.point = point;
    this.userRole = userRole;

}

}
