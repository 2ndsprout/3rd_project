package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
public class SiteUser {

    @Id
    private String username;

    @Column
    @Size(min = 8, max = 11)
    private String password;

    @Email
    private String email;

    private String nickname;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private Integer phoneNumber;

    private Integer point;

@Builder
    public SiteUser(String username,String password,String email, String nickname,int phoneNumber,int point){
    this.username = username;
    this.password = password;
    this.email = email;
    this.nickname = nickname;
    this.phoneNumber = phoneNumber;
    this.point = point;
}

}
