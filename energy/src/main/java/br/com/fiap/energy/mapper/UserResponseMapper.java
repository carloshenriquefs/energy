package br.com.fiap.energy.mapper;

import br.com.fiap.energy.dto.response.UserResponse;
import br.com.fiap.energy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    UserResponse userToUserReponse(User user);

    User userReponseToUser(Optional<User> userResponse);
}
