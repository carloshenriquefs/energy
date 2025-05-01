package br.com.fiap.energy.dto.response;

public record UserResponse(
        Long id,
        String name,
        String email,
        String kind
) {
}
