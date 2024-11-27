package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.UserInformationRequestDTO;
import com._ndsprout.Education_platform.DTO.UserInformationResponseDTO;
import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Exceptions.BadRequest;
import com._ndsprout.Education_platform.Exceptions.DataDuplicateException;
import com._ndsprout.Education_platform.Records.TokenRecord;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final MultiService multiService;

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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호 오류");
        }
        else return tokenRecord.getResponseEntity();
    }

    @PutMapping("/updateIntroduce")
    public ResponseEntity<?> updateIntroduce(@RequestHeader("Authorization") String accessToken,@RequestBody UserInformationRequestDTO userInformationRequestDTO){
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        if(tokenRecord.isOK()) try{
            UserInformationResponseDTO userInformationResponseDTO = this.multiService.updateIntroduce(tokenRecord.username(),userInformationRequestDTO.introduce());
            return ResponseEntity.status(HttpStatus.OK).body(userInformationResponseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        else return tokenRecord.getResponseEntity();
    }
}
