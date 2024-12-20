package com._ndsprout.Education_platform.Service;

import com._ndsprout.Education_platform.Annotation.AuthCheck;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Security.Jwt.JwtTokenProvider;
import com._ndsprout.Education_platform.Service.Module.SiteUserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthCheckAspect {

    private final JwtTokenProvider jwtTokenProvider; // 토큰 처리 클래스 의존성 주입
    private final SiteUserService siteUserService;   // 사용자 정보 조회 서비스

    public AuthCheckAspect(JwtTokenProvider jwtTokenProvider, SiteUserService siteUserService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.siteUserService = siteUserService;
    }

    @Around("@annotation(authCheck)")
    public Object authCheck(ProceedingJoinPoint pjp, AuthCheck authCheck) throws Throwable {
        // 현재 요청의 Authorization 헤더에서 액세스 토큰 가져오기
        String token = extractAccessToken();
        if (token == null || !jwtTokenProvider.validateToken(token)) {
            throw new AccessDeniedException("유효하지 않은 토큰입니다.");
        }

        // 토큰에서 username 추출
        String username = jwtTokenProvider.getUsernameFromToken(token);

        // username 기반으로 사용자 정보 조회
        SiteUser user = siteUserService.get(username);
        if (user == null) {
            throw new AccessDeniedException("사용자를 찾을 수 없습니다.");
        }

        // @AuthCheck에 지정된 roles와 사용자 역할 비교
        String[] requiredRoles = authCheck.roles();
        String userRole = user.getUserRole().getValue(); // 예: "ROLE_ADMIN", "ROLE_USER" 등

        for (String role : requiredRoles) {
            if (userRole.equals(role)) {
                return pjp.proceed(); // 권한이 있으면 메서드 실행
            }
        }

        throw new AccessDeniedException("접근 권한이 없습니다.");
    }

    private String extractAccessToken() {
        // SecurityContextHolder 또는 HttpServletRequest를 통해 Authorization 헤더에서 토큰 추출
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getCredentials() instanceof String) {
            return (String) auth.getCredentials();
        }
        return null;
    }
}
