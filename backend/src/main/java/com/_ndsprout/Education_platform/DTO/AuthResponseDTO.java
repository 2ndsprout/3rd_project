package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

@Builder
public record AuthResponseDTO(String tokenType,String accessToken, String refreshToken) {
}
