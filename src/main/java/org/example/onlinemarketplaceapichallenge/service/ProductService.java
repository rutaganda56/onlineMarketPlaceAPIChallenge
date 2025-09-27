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
    public Product updateProduct(int id, Product product) {
        var existingUser=productRepo.findById(id).orElse(new Product());
        existingUser.setId(product.getId());
        existingUser.setName(product.getName());
        existingUser.setPrice(product.getPrice());
        return productRepo.save(existingUser);
    }
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
