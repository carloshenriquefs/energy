package br.com.fiap.energy.dto.response;

import br.com.fiap.energy.entity.UserRole;

public record UserResponse(
        Long id,
        String name,
        String email,
        UserRole role
) {
}
