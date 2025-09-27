package org.example.onlinemarketplaceapichallenge.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StoreDto(
        @NotEmpty
        String storeName,
        @NotEmpty
        String storeAddress,
        @NotEmpty
        String contact,
        @NotNull
        int userId
) {
}
