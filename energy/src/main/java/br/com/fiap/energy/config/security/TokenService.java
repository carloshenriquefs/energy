package br.com.fiap.energy.config.security;

import br.com.fiap.energy.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static br.com.fiap.energy.constants.Constants.UNABLE_GENERATE_TOKEN;

@Service
public class TokenService {

    @Value("${my.secret.key}")
    private String secretWord;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretWord);
            String token = JWT
                    .create()
                    .withIssuer("employee")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException error) {
            throw new RuntimeException(UNABLE_GENERATE_TOKEN);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretWord);

            return JWT.require(algorithm)
                    .withIssuer("employee")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException error) {
            return "";
        }
    }

    public Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
