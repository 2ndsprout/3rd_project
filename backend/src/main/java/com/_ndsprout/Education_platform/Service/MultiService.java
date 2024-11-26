package com._ndsprout.Education_platform.Service;

import com._ndsprout.Education_platform.DTO.CategoryResponseDTO;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Exceptions.DataNotFoundException;
import com._ndsprout.Education_platform.Records.TokenRecord;
import com._ndsprout.Education_platform.Security.CustomUserDetails;
import com._ndsprout.Education_platform.Security.Jwt.JwtTokenProvider;
import com._ndsprout.Education_platform.Service.Module.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiService {

    private final ArticleService articleService;
    private final ArticleTagService articleTagService;
    private final CartNotificationService cartNotificationService;
    private final CartService cartService;
    private final CategoryService categoryService;
    private final ChatMessageService chatMessageService;
    private final ChatParticipantsService chatParticipantsService;
    private final ChatRoomService chatRoomService;
    private final CommunityService communityService;
    private final FileSystemService fileSystemService;
    private final LessonService lessonService;
    private final LessonTagService lessonTagService;
    private final LessonUserService lessonUserService;
    private final MultiKeyService multiKeyService;
    private final NotificationService notificationService;
    private final PaymentLessonService paymentLessonService;
    private final PaymentLogService paymentLogService;
    private final ReplyService replyService;
    private final ReviewService reviewService;
    private final ReviewNotificationService reviewNotificationService;
    private final SearchLogService searchLogService;
    private final SectionService sectionService;
    private final SiteUserService siteUserService;
    private final TagLogService tagLogService;
    private final TagService tagService;
    private final WatchLogService watchLogService;
    private final WishListService wishListService;
    private final JwtTokenProvider jwtTokenProvider;



    /**
     * 토큰
     */
    public TokenRecord checkToken(String accessToken) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        String username = null;
        String body = "logout";
        if (accessToken != null && accessToken.length() > 7) {
            String token = accessToken.substring(7);
            if (this.jwtTokenProvider.validateToken(token)) {
                httpStatus = HttpStatus.OK;
                username = this.jwtTokenProvider.getUsernameFromToken(token);
                body = "okay";
            } else {
                httpStatus = HttpStatus.UNAUTHORIZED;
                body = "refresh";
            }
        }
        return TokenRecord.builder().httpStatus(httpStatus).username(username).body(body).build();
    }

    public TokenRecord checkToken(String accessToken, Long profile_id) {
        if (profile_id == null)
            return TokenRecord.builder().httpStatus(HttpStatus.UNAUTHORIZED).body("unknown profile").build();
        return checkToken(accessToken);
    }

    @Transactional
    public String refreshToken(String refreshToken) {
        if (this.jwtTokenProvider.validateToken(refreshToken)) {
            String username = jwtTokenProvider.getUsernameFromToken(refreshToken);
            SiteUser user = siteUserService.get(username);
            if (user != null) {
                return this.jwtTokenProvider.generateAccessToken(new UsernamePasswordAuthenticationToken(new CustomUserDetails(user), user.getPassword()));
            }
        }
        return null;
    }

    /**
     * 카테고리
     */

    @Transactional
    public CategoryResponseDTO saveCategory(String username, Long aLong, String name, Long profileId) {
        SiteUser user = this.userCheck(username);
        // 로그인 기능 완성되는대로 카테고리 생성에 유저 권한 인증해야함
    }

    /**
     * 유저 체크
     */
    @Transactional
    private SiteUser userCheck(String userName) {
        SiteUser user = siteUserService.get(userName);
        if (user == null) throw new DataNotFoundException("유저 객체 없음");
        return user;
    }


    //유저관련

    //회원가입
//    public Boolean signup(UserSignUpRequestDTO userSignUpRequestDTO) {
//
//    }
}
