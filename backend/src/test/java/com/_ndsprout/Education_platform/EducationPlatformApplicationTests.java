package com._ndsprout.Education_platform;

import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Repository.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EducationPlatformApplicationTests {

	@Autowired
	private SiteUserRepository siteUserRepository;
	@Test
	void contextLoads() {
		SiteUser siteUser = SiteUser.builder().username("admin1").password("12345678").point(0).phoneNumber("01043004893").email("tjddjs@naver.com").build();
		siteUserRepository.save(siteUser);
	}

	@Test
	void modifty(){
		SiteUser siteUser = siteUserRepository.findByUsername("admin1");
		siteUser.setPoint(100);
		siteUserRepository.save(siteUser);
	}

}
