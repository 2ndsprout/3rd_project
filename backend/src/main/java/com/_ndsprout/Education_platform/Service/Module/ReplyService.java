package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
}
