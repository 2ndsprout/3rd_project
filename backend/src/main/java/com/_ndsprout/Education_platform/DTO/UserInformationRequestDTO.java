package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

@Builder
public record UserInformationRequestDTO(String nowPassword,String password,String email, String phoneNumber,String introduce) {
}
