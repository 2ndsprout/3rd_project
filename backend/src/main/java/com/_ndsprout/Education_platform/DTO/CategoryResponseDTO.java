package com._ndsprout.Education_platform.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public record CategoryResponseDTO(String name, String prentCategory, List<CategoryResponseDTO> childrenResponseDTO, Long createDate, Long modifyDate) {
}
