package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

@Builder
public record AuthRequestDTO(String username, String password) {
}
