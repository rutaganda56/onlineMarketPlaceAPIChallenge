package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.ProductDto;
import org.example.onlinemarketplaceapichallenge.Dto.ProductResponseDto;
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
        product.setStore(store);
        return product;
    }
    public ProductResponseDto transformToResponseDto(Product product) {
        return new ProductResponseDto(product.getName());

    }
}
