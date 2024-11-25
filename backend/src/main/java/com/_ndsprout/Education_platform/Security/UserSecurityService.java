package com._ndsprout.Education_platform.Security;

import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final SiteUserRepository siteUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteuser = this.siteUserRepository.findById(username);
        if (_siteuser.isEmpty())
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        UserDetails userDetails = new CustomUserDetails(_siteuser.get());
        return userDetails;
    }
}
