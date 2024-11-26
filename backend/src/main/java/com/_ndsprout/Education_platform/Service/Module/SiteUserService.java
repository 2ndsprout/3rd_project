package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Enum.UserRole;
import com._ndsprout.Education_platform.Exception.BadRequest;
import com._ndsprout.Education_platform.Exception.DataDuplicateException;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;

    public void UserSignup(UserSignUpRequestDTO userSignUpRequestDTO) {
        Optional<SiteUser> _SiteUser = siteUserRepository.findByUsername(userSignUpRequestDTO.username());
        if (_SiteUser.isPresent())
            throw new DataDuplicateException("중복된 유저네임");
        if(userSignUpRequestDTO.role() == 1) {
            siteUserRepository.save(new SiteUser(userSignUpRequestDTO.username(), userSignUpRequestDTO.password(), userSignUpRequestDTO.email(), userSignUpRequestDTO.nickname(), userSignUpRequestDTO.phoneNumber(), 0, UserRole.USER));
        }else if(userSignUpRequestDTO.role() == 2){
            siteUserRepository.save(new SiteUser(userSignUpRequestDTO.username(), userSignUpRequestDTO.password(), userSignUpRequestDTO.email(), userSignUpRequestDTO.nickname(), userSignUpRequestDTO.phoneNumber(), 0, UserRole.TEACHER));
        }else{
            throw new BadRequest("잘못된 권한입니다");
        }
    }

}
