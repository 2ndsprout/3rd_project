package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.DTO.CategoryRequestDTO;
import com._ndsprout.Education_platform.DTO.CategoryResponseDTO;
import com._ndsprout.Education_platform.Exceptions.DataNotFoundException;
import com._ndsprout.Education_platform.Records.TokenRecord;
import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private MultiService multiService;

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestHeader("Authorization") String accessToken,
                                          @RequestBody CategoryRequestDTO requestDTO) {
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        try {
            if (tokenRecord.isOK()) {
                String username = tokenRecord.username();
                CategoryResponseDTO responseDTO = multiService.saveCategory(username, requestDTO.parentName(), requestDTO.name());
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            }
        } catch (DataNotFoundException | IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return tokenRecord.getResponseEntity();
    }

    @GetMapping
    public ResponseEntity<?> getCategory(@RequestHeader("Authorization") String accessToken,
                                         @RequestHeader("CategoryName") String categoryName) {
        TokenRecord tokenRecord = this.multiService.checkToken(accessToken);
        try {
            if (tokenRecord.isOK()) {
                String username = tokenRecord.username();
                CategoryResponseDTO categoryResponseDTO = multiService.getCategory(categoryName, username);
                return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDTO);
            }
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return tokenRecord.getResponseEntity();
    }
}
