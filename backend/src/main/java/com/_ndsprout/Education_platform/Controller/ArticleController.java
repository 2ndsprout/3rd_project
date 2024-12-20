package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.ArticleRequestDTO;
import com._ndsprout.Education_platform.Record.TokenRecord;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
private final MultiService multiService;
//    @PostMapping
//    public ResponseEntity<?> createArticle(@RequestHeader("Authorization") String accessToken, ArticleRequestDTO articleRequestDTO){
//        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
//        if(tokenRecord.isOK()) try{
//            this.multiService.createArticle(tokenRecord.username(),articleRequestDTO.title(),articleRequestDTO.content(),articleRequestDTO.communityName());
//        }
//    }
}
