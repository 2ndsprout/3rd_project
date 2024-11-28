package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

@Builder
public record UserInformationResponseDTO(String username,String email,String nickname, String introduce,String phoneNumber,int point) {
}
