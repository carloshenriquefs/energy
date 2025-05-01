package br.com.fiap.energy.mapper;

import br.com.fiap.energy.dto.request.UserRequest;
import br.com.fiap.energy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    UserRequest userToUserRequest(User user);

    User userRequestToUser(UserRequest userRequest);
}
