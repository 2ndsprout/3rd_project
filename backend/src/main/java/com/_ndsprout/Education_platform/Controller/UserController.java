package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Exception.BadRequest;
import com._ndsprout.Education_platform.Exception.DataDuplicateException;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final MultiService multiService;

    @PostMapping("/SingUp")
    public ResponseEntity<?> createUser (UserSignUpRequestDTO userSignUpRequestDTO){
        try {
            multiService.signup(userSignUpRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }catch (DataDuplicateException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAIL");
        }catch (BadRequest ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ROLE ERROR");
        }
    }
}
