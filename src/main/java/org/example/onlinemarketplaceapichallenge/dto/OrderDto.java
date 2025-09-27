package org.example.onlinemarketplaceapichallenge.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderDto(
        @NotEmpty
        int quantity,
        @NotNull
        long price,
        @NotEmpty
        String shippingMethod,
        @NotEmpty
        String status,
        @NotNull
        int userId,
        @NotNull
        int productId
) {
}
