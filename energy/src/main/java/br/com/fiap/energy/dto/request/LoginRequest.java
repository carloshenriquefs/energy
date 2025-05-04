package br.com.fiap.energy.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "User email is required!")
        @Email(message = "The user's email is not valid!")
        String email,

        @NotBlank(message = "User password is required!")
        @Size(min = 6, max = 20, message = " The password must contain between 6 and 20 characters!")
        String password
) {
}
