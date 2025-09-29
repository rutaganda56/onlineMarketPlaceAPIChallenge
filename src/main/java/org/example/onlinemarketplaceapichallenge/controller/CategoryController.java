package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.validation.Valid;
import org.example.onlinemarketplaceapichallenge.dto.CategoryDto;
import org.example.onlinemarketplaceapichallenge.dto.CategoryResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Category;
import org.example.onlinemarketplaceapichallenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/getCategories")
    public List<CategoryResponseDto> getCategories() {
        return categoryService.getCategories();
    }
    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@Valid @RequestBody CategoryDto dto){
        return categoryService.createCategory(dto);
    }
    @PutMapping("/editCategory/{id}")
    public Category updateCategory(@PathVariable("id") int id,@Valid @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        var errors=new HashMap<String,String>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            var fieldName= ((FieldError) error).getField();
            var errorMsg=error.getDefaultMessage();
            errors.put(fieldName,errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
