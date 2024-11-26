package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

@Builder
public record UserSignUpRequestDTO(String username, String password, String email,String nickname,String phoneNumber,int role) {
}
