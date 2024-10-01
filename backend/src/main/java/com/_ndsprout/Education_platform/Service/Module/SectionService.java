package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
}
