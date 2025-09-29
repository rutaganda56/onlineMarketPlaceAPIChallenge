package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.CategoryDto;
import org.example.onlinemarketplaceapichallenge.dto.CategoryResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.CategoryMapper;
import org.example.onlinemarketplaceapichallenge.model.Category;
import org.example.onlinemarketplaceapichallenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private CategoryMapper categoryMapper;
    public List<CategoryResponseDto> getCategories() {
        return categoryRepo.findAll().stream().map(categoryMapper::transformToResponseDto).collect(Collectors.toList());
    }
    public CategoryResponseDto createCategory(CategoryDto categoryDto) {
        var category=categoryMapper.transformToDto(categoryDto);
        var savedCategory=categoryRepo.save(category);
        return categoryMapper.transformToResponseDto(savedCategory);
    }
    public CategoryResponseDto updateCategory(int id, CategoryDto categoryDto) {
        var existingUser=categoryRepo.findById(id).orElse(null);
        existingUser.setName(categoryDto.name());
        var savedUser= categoryRepo.save(existingUser);
        return categoryMapper.transformToResponseDto(savedUser);

    }
    public void deleteCategory(int categoryId) {
        categoryRepo.deleteById(categoryId);
    }

}
