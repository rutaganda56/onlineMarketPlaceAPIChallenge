package org.example.onlinemarketplaceapichallenge.Dto;

import jakarta.validation.constraints.NotEmpty;

public record CategoryDto(
        @NotEmpty
       String name
) {
}
