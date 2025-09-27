package org.example.onlinemarketplaceapichallenge.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

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
