package com._ndsprout.Education_platform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SiteUser {

    @Id
    private String username;

    @Column
    @Size(min = 8, max = 11)
    private String password;

    @Email
    private String email;

    private String nickname;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private int phoneNumber;

    private int point;



}
