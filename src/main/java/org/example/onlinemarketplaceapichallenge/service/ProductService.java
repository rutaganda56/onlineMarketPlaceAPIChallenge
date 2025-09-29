package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.dto.ProductResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.ProductMapper;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductResponseDto> getAllProducts() {
        return productRepo.findAll().stream().map(productMapper::transformToResponseDto).collect(Collectors.toList());
    }
    public ProductResponseDto createProduct(ProductDto productDto) {
        var product=productMapper.transformToDto(productDto);
        var savedProduct=productRepo.save(product);
        return productMapper.transformToResponseDto(savedProduct);
    }
    public ProductResponseDto updateProduct(int id, ProductDto productDto) {
        var existingUser=productRepo.findById(id).orElse(new Product());
        existingUser.setId(productDto.storeId());
        existingUser.setName(productDto.name());
        existingUser.setPrice(productDto.price());
        var updatedProduct=productRepo.save(existingUser);
        return new ProductResponseDto(updatedProduct.getName());
    }
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
