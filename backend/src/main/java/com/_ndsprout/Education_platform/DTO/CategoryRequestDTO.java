package com._ndsprout.Education_platform.Dto;


import lombok.Builder;

@Builder
public record CategoryRequestDTO(String parentName, String name) {
}
