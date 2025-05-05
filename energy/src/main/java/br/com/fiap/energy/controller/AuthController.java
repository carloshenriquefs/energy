package br.com.fiap.energy.controller;

import br.com.fiap.energy.config.security.TokenService;
import br.com.fiap.energy.dto.request.LoginRequest;
import br.com.fiap.energy.dto.request.UserRequest;
import br.com.fiap.energy.dto.response.TokenResponse;
import br.com.fiap.energy.dto.response.UserResponse;
import br.com.fiap.energy.entity.User;
import br.com.fiap.energy.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                );

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = null;
        userResponse = userService.save(userRequest);

        return ResponseEntity.created(URI.create("/auth" + userResponse.id())).build();
    }
}
