package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.CategoryDto;
import org.example.onlinemarketplaceapichallenge.Dto.CategoryResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Category transformToDto(CategoryDto dto){
        Category category = new Category();
        category.setName(dto.name());
        return category;
    }

    public CategoryResponseDto transformToResponseDto(Category category){
        return new CategoryResponseDto(category.getName());
    }
}
