package com._ndsprout.Education_platform.Security;

import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Enum.UserRole;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public void run(String... args) throws Exception {
        Optional<SiteUser> _admin = siteUserRepository.findByUsername("admin");
        if (_admin.isEmpty()) {
            SiteUser admin = SiteUser.builder()
                    .username("admin")
                    .email("admin@honeydanji.co.kr")
                    .userRole(UserRole.ADMIN)
                    .password(passwordEncoder.encode("123456789"))
                    .build();
            this.siteUserRepository.save(admin);
            System.out.println("Admin account created");
        } else {
            System.out.println("Admin account already exists");
        }
    }
}
