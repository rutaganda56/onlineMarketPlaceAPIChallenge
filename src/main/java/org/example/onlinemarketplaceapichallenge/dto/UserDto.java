package org.example.onlinemarketplaceapichallenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record UserDto(@NotEmpty
                       String username
                      , @NotEmpty  String password
                      ,@NotEmpty @Email String email
                      , @NotEmpty(message = "the role should be containing 'ROLE_'") @Pattern(regexp = "^ROLE_.*") String role
                       , @Pattern(regexp = "^[0-9]{10}$") @NotEmpty(message = "the company's phone should not be empty")
                      String phone
                       ,@NotEmpty @Pattern(regexp = "^[\\p{L}]+([ '-][\\p{L}]+)*$") String fullName){
}
