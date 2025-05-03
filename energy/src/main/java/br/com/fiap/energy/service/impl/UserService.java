package br.com.fiap.energy.service.impl;

import br.com.fiap.energy.dto.request.UserRequest;
import br.com.fiap.energy.dto.response.UserResponse;
import br.com.fiap.energy.entity.User;
import br.com.fiap.energy.exception.UserNotFoundException;
import br.com.fiap.energy.mapper.UserRequestMapper;
import br.com.fiap.energy.mapper.UserResponseMapper;
import br.com.fiap.energy.repository.UserRepository;
import br.com.fiap.energy.service.ServiceAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.energy.constants.Constants.USER_NOT_FOUND;

@Service
public class UserService implements ServiceAdapter<UserResponse, UserRequest> {

    private final UserRepository userRepository;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    public UserService(UserRepository userRepository,
                       UserRequestMapper userRequestMapper,
                       UserResponseMapper userResponseMapper) {

        this.userRepository = userRepository;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = userRequestMapper.userRequestToUser(userRequest);
        user = userRepository.save(user);

        return userResponseMapper.userToUserReponse(user);
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userResponseMapper::userToUserReponse)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }


    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userResponseMapper::userToUserReponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
