package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.FileSystemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileSystemService {
    private final FileSystemRepository fileSystemRepository;
}
