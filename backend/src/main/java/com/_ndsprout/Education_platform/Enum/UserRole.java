package com._ndsprout.Education_platform.Enum;

import lombok.Getter;

@Getter
public enum UserRole {

    ADMIN, USER, TEACHER;

    public String getValue(){
        return "ROLE_"+this.name();
    }
}
