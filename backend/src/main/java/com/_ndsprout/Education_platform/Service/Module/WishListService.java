package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;
}
