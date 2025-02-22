package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.UserInformationRequestDTO;
import com._ndsprout.Education_platform.DTO.UserInformationResponseDTO;
import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Exception.BadRequest;
import com._ndsprout.Education_platform.Exception.DataDuplicateException;
import com._ndsprout.Education_platform.Record.TokenRecord;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final MultiService multiService;

    @GetMapping("/listUp")
    public ResponseEntity<?> userListUp(@RequestHeader("Authorization") String accessToken) {
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if (tokenRecord.isOK()) {
            try {
                List<UserInformationResponseDTO> userList = this.multiService.getUserListUp();
                return ResponseEntity.status(HttpStatus.OK).body(userList);
            } catch (AccessDeniedException ex) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("접근이 불가합니다.");
            }
        } else {
            return tokenRecord.getResponseEntity();
        }
    }


    //회원가입
    @PostMapping("/SingUp")
    public ResponseEntity<?> createUser(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) {
        try {
            multiService.signUp(userSignUpRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (DataDuplicateException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAIL");
        } catch (BadRequest ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ROLE ERROR");
        }
    }

    //비민번호 변경
    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestHeader("Authorization") String accessToken, @RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
                this.multiService.updatePassword(tokenRecord.username(),userInformationRequestDTO.nowPassword(),userInformationRequestDTO.password());
                return ResponseEntity.status(HttpStatus.OK).body("변경완료");
            }catch (BadRequest e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }
    // 소개 변경
    @PutMapping("/updateIntroduce")
    public ResponseEntity<?> updateIntroduce(@RequestHeader("Authorization") String accessToken,@RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
            UserInformationResponseDTO userInformationResponseDTO = this.multiService.updateIntroduce(tokenRecord.username(),userInformationRequestDTO.introduce());
            return ResponseEntity.status(HttpStatus.OK).body(userInformationResponseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BadRequest e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }

    //이메일 변경
    @PutMapping("/updateEmail")
    public ResponseEntity<?> updateEmail(@RequestHeader("Authorization") String accessToken,@RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
            UserInformationResponseDTO userInformationResponseDTO = this.multiService.updateEmail(tokenRecord.username(),userInformationRequestDTO.email());
            return ResponseEntity.status(HttpStatus.OK).body(userInformationResponseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BadRequest e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }

    //닉네임 변경
    @PutMapping("/updateNickname")
    public ResponseEntity<?> updateNickname(@RequestHeader("Authorization") String accessToken,@RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
            UserInformationResponseDTO userInformationResponseDTO = this.multiService.updateNickname(tokenRecord.username(),userInformationRequestDTO.nickname());
            return ResponseEntity.status(HttpStatus.OK).body(userInformationResponseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BadRequest e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }

    //핸드폰번호 변경
    @PutMapping("updatePhoneNumber")
    public ResponseEntity<?> updatePhoneNumber(@RequestHeader("Authorization") String accessToken,@RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try {
            UserInformationResponseDTO userInformationResponseDTO = this.multiService.updatePhoneNumber(tokenRecord.username(),userInformationRequestDTO.phoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(userInformationResponseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BadRequest e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }
}
