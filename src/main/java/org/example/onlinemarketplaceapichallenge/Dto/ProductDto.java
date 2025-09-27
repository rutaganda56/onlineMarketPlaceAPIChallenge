package org.example.onlinemarketplaceapichallenge.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDto(
        @NotEmpty
        String name,
        @NotEmpty
        String price,
        @NotEmpty
        String status,
        @NotNull
        int categoryId,
        @NotNull
        int storeId
) {
}
