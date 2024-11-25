package com._ndsprout.Education_platform.Controller;

import com._ndsprout.Education_platform.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final MultiService multiService;

}
