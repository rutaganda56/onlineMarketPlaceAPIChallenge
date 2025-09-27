package org.example.onlinemarketplaceapichallenge.controller;

import org.example.onlinemarketplaceapichallenge.dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.dto.ProductResponseDto;
import org.example.onlinemarketplaceapichallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<ProductResponseDto> getProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
