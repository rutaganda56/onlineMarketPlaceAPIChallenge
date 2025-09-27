package org.example.onlinemarketplaceapichallenge.Dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StoreDto(
        @NotEmpty
        String storeName,
        @NotEmpty
        String storeAddress,
        @NotEmpty
        String Contact,
        @NotNull
        int userId
) {
}
