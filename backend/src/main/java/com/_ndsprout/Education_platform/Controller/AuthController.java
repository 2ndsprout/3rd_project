package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final MultiService multiService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody com._ndsprout.Education_platform.DTO.AuthRequestDTO authRequestDTO) {
        try {
            com._ndsprout.Education_platform.DTO.AuthResponseDTO authResponseDTO = multiService.login(authRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(authResponseDTO);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("REFRESH_TOKEN") String refreshToken) {
        String newAccessToken = this.multiService.refreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.OK).body(newAccessToken);
    }
}
