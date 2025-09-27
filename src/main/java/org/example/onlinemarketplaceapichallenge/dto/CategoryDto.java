package org.example.onlinemarketplaceapichallenge.dto;

import jakarta.validation.constraints.NotEmpty;

public record CategoryDto(
        @NotEmpty
       String name
) {
}
