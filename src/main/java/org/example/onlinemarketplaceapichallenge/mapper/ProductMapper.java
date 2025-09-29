package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.dto.ProductResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Category;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Store;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product transformToDto(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setStatus(dto.status());
        Store store = new Store();
        store.setStoreId(dto.storeId());
        Category category = new Category();
        category.setId(dto.categoryId());
        product.setCategory(category);
        product.setStore(store);
        return product;
    }
    public ProductResponseDto transformToResponseDto(Product product) {
        return new ProductResponseDto(product.getName());

    }
}
