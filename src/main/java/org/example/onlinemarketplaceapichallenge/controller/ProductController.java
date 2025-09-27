package org.example.onlinemarketplaceapichallenge.controller;

import org.example.onlinemarketplaceapichallenge.Dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.Dto.ProductResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
