package com._ndsprout.Education_platform.Service.Module;

import com._ndsprout.Education_platform.Entity.Category;
import com._ndsprout.Education_platform.Exception.DataNotFoundException;
import com._ndsprout.Education_platform.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findByCategoryName(String name) {
        Optional<Category> _category = categoryRepository.findByCategoryName(name);
        if (_category.isEmpty()) throw new DataNotFoundException("카테고리 객체 없음");
        return _category.get();
    }

    public List<Category> findByParentCategoryList(Category parentCategory) {
        return this.categoryRepository.findByParentCategory(parentCategory);
    }

    public Category save(Category prentCategory, String name) {
        return categoryRepository.save(Category.builder() //
                .name(name) //
                .parent(prentCategory) //
                .build());
    }
}
