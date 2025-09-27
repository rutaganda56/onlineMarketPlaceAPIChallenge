package org.example.onlinemarketplaceapichallenge.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record ReviewDto(
        @NotNull
        int rating,
        @NotEmpty
        String comment,
        @NotNull @Positive
        int userId,
        @NotNull @Positive
        int productId
) {
}
