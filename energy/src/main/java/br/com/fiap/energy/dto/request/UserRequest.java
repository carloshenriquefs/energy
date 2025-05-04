package br.com.fiap.energy.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @NotBlank(message = "Username is required!")
        String name,

        @NotBlank(message = "E-mail is required")
        @Email(message = "The user's e-mail is not valid!")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, max = 12, message = "The password must contain between 6 and 12 characteres!")
        String password,

        @NotBlank(message = "The kind is required!")
        String kind
) {
}
