package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findByCategoryName(String name) {
        Optional<Category> _category = categoryRepository.findByCategoryName(name);
        return _category.orElse(null);
    }


    public Category save(Category prentCategory, String name) {
        return categoryRepository.save(Category.builder() //
                .name(name) //
                .parent(prentCategory) //
                .build());
    }

}
