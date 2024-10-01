package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
}
