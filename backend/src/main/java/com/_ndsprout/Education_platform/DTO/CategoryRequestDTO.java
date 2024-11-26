package com._ndsprout.Education_platform.DTO;


import lombok.Builder;

@Builder
public record CategoryRequestDTO(String parentName, String name) {
}
