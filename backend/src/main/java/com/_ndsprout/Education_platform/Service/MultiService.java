package com._ndsprout.Education_platform.Service;


import com._ndsprout.Education_platform.DTO.AuthRequestDTO;
import com._ndsprout.Education_platform.DTO.AuthResponseDTO;
import com._ndsprout.Education_platform.DTO.CategoryResponseDTO;
import com._ndsprout.Education_platform.DTO.UserSignUpRequestDTO;
import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Entity.SiteUser;
import com._ndsprout.Education_platform.Enum.UserRole;
import com._ndsprout.Education_platform.Exceptions.DataNotFoundException;
import com._ndsprout.Education_platform.Records.TokenRecord;
import com._ndsprout.Education_platform.Security.CustomUserDetails;
import com._ndsprout.Education_platform.Security.Jwt.JwtTokenProvider;
import com._ndsprout.Education_platform.Service.Module.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
    public CategoryResponseDTO saveCategory(String username, String parentName, String name) {
        SiteUser user = this.userCheck(username);
        Category prentCategory = null;
        if (user.getUserRole() != UserRole.ADMIN) throw new IllegalArgumentException("어드민 권한 아님");
        if (parentName != null) {
            prentCategory = categoryService.findByCategoryName(parentName);
        }
        Category category = categoryService.save(prentCategory, name);
        return this.categoryResponseDTO(category);
    }

    public CategoryResponseDTO categoryResponseDTO(Category category) {
        List<String> childrenNameList = new ArrayList<>();
        if (category.getChildren() != null)
            for (Category childrenCategory : category.getChildren()) {
                childrenNameList.add(childrenCategory.getCategoryName());
            }
        return CategoryResponseDTO.builder()//
                .name(category.getCategoryName()) //
                .prentCategory(category.getParent().getCategoryName()) //
                .childrenName(childrenNameList) //
                .createDate(this.dateTimeTransfer(category.getCreateDate())) //
                .modifyDate(this.dateTimeTransfer(category.getModifyDate())) //
                .build();
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

    /**
     *
     */
    private Long dateTimeTransfer(LocalDateTime dateTime) {

        if (dateTime == null) {
            return null;
        }
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    //유저관련

    //회원가입

    @Transactional
    public void signUp(UserSignUpRequestDTO userSignUpRequestDTO) {
        siteUserService.signUp(userSignUpRequestDTO);
    }

    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        SiteUser siteUser = siteUserService.get(authRequestDTO.username());
        if(siteUser == null)
            throw  new IllegalArgumentException("username");

        if(!this.siteUserService.isMatch(authRequestDTO.password(), siteUser.getPassword()))
            throw new IllegalArgumentException("password");

        //추후 유저 계정 잠금 기능 만들어지면 계정 활성화 여부 체크하는 로직 추가할것

        String accessToken = this.jwtTokenProvider.generateAccessToken(new UsernamePasswordAuthenticationToken(new CustomUserDetails(siteUser),siteUser.getPassword()));
        String refreshToken = this.jwtTokenProvider.generateRefreshToken(new UsernamePasswordAuthenticationToken(new CustomUserDetails(siteUser),siteUser.getPassword()));
        return AuthResponseDTO.builder().tokenType("Bearer").accessToken(accessToken).refreshToken(refreshToken).build();
    }
}
