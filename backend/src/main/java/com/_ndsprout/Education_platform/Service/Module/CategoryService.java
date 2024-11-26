package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(String parentId) {
        return categoryRepository.findByCategoryName(parentId);
    }
}
