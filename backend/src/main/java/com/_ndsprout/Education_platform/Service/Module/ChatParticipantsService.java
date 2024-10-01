package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.ChatParticipantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatParticipantsService {
    private final ChatParticipantsRepository chatParticipantsRepository;
}
