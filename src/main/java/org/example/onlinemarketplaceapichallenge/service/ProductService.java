package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.dto.ProductResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.ProductMapper;
import org.example.onlinemarketplaceapichallenge.model.Category;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Store;
import org.example.onlinemarketplaceapichallenge.repository.CategoryRepository;
import org.example.onlinemarketplaceapichallenge.repository.ProductRepository;
import org.example.onlinemarketplaceapichallenge.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired private CategoryRepository categoryRepo;
    @Autowired private StoreRepository storeRepo;
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
    public ProductResponseDto updateProduct(int productId, ProductDto updateDto) {
        Product existingProduct = productRepo.findById(productId).orElse(new Product());
        Category newCategory = categoryRepo.findById(updateDto.categoryId())
                .orElse(new Category());
        Store newStore = storeRepo.findById(updateDto.storeId())
                .orElse(new Store());
        existingProduct.setCategory(newCategory);
        existingProduct.setStore(newStore);
        existingProduct.setName(updateDto.name());
        existingProduct.setStatus(updateDto.status());
        existingProduct.setPrice(updateDto.price());
        Product savedProduct = productRepo.save(existingProduct);
        return productMapper.transformToResponseDto(savedProduct);
        }
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}

