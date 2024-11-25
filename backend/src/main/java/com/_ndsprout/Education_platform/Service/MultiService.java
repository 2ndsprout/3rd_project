package com._ndsprout.Education_platform.Service;

import com._ndsprout.Education_platform.Service.Module.*;
import lombok.RequiredArgsConstructor;
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

}
