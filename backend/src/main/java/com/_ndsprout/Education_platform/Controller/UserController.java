package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final MultiService multiService;

    @PostMapping
    public Boolean createUser (UserSignUpRequestDTO userSignUpRequestDTO){
        Boolean success = multiService.signup(userSignUpRequestDTO);
    }
}
