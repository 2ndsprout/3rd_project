package com._ndsprout.Education_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EducationPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationPlatformApplication.class, args);
	}

}
