package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.CommunityRequestDTO;
import com._ndsprout.Education_platform.Record.TokenRecord;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommunityController {
    private final MultiService multiService;
    @PostMapping
    public ResponseEntity<?> createCommunity(@RequestHeader("Authorization") String accessToken, @RequestBody CommunityRequestDTO communityRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
            multiService.createCommunity(tokenRecord.username(),communityRequestDTO.communityName());
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }catch (AccessDeniedException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
        return tokenRecord.getResponseEntity();
    }
}
