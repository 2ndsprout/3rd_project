package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Enum.UserRole;
import com._ndsprout.Education_platform.Exception.BadRequest;
import com._ndsprout.Education_platform.Exception.DataDuplicateException;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SiteUser get(String value){
        return this.siteUserRepository.findById(value).orElse(null);
    }



    public void signUp(UserSignUpRequestDTO userSignUpRequestDTO) {
        Optional<SiteUser> _SiteUser = siteUserRepository.findByUsername(userSignUpRequestDTO.username());
        if (_SiteUser.isPresent())
            throw new DataDuplicateException("중복된 유저네임");
        if (userSignUpRequestDTO.role() == 1) {
            siteUserRepository.save(SiteUser.builder() //
                    .username(userSignUpRequestDTO.username()) //
                    .password(passwordEncoder.encode(userSignUpRequestDTO.password())) //
                    .email(userSignUpRequestDTO.email()) //
                    .nickname(userSignUpRequestDTO.nickname()) //
                    .phoneNumber(userSignUpRequestDTO.phoneNumber()) //
                    .point(0) //
                    .userRole(UserRole.USER) //
                    .build()//
            );
        } else if (userSignUpRequestDTO.role() == 2) {
            siteUserRepository.save(SiteUser.builder() //
                    .username(userSignUpRequestDTO.username()) //
                    .password(passwordEncoder.encode(userSignUpRequestDTO.password())) //
                    .email(userSignUpRequestDTO.email()) //
                    .nickname(userSignUpRequestDTO.nickname()) //
                    .phoneNumber(userSignUpRequestDTO.phoneNumber()) //
                    .point(0) //
                    .userRole(UserRole.TEACHER) //
                    .build() //
            );
        } else {
            throw new BadRequest("잘못된 권한입니다");
        }
    }

    public Boolean isMatch(String password1, String password2){
        return passwordEncoder.matches(password1,password2);
    }

    public void updatePassword(String username,String nowPassword, String password) {
        Optional<SiteUser> _siteUser = this.siteUserRepository.findByUsername(username);
        if(_siteUser.isPresent()) {
            SiteUser siteUser = _siteUser.get();

            if (!this.isMatch(nowPassword,siteUser.getPassword()))
                throw new BadRequest("password error");
            siteUser.setPassword(this.passwordEncoder.encode(password));
            siteUserRepository.save(siteUser);
        }
    }

    public SiteUser updateIntroduce(String username, String introduce) {
        Optional<SiteUser> _siteUser = siteUserRepository.findByUsername(username);
        if(_siteUser.isPresent()){
            SiteUser siteUser = _siteUser.get();
            siteUser.setIntroduce(introduce);
            return siteUserRepository.save(siteUser);
        }
        else throw new IllegalArgumentException("유저없음");
    }
}
