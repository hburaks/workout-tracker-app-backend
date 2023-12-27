package com.hbdev.workouttrackerbackend.util.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hbdev.workouttrackerbackend.Exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class JWTUtil {


    private final UserEntityRepository userEntityRepository;
    Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
        return JWT.create().withSubject("User Details").withClaim("email", email).withIssuedAt(new Date()).withIssuer("HBDEV").sign(Algorithm.HMAC256(secret));
    }


    public String validateTokenAndRetrieveSubject(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).withSubject("User Details").withIssuer("HBDEV").build();

            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("email").asString();
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Required token is not provided", e);
        }
    }


    public UserEntity findUserByEmail(String email) {
        return userEntityRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
    }

    public UserEntity findUserByRequest(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
                String jwt = authHeader.substring(7);

                if (!jwt.isBlank()) {
                    String email = validateTokenAndRetrieveSubject(jwt);
                    if (email != null) {
                        UserEntity userEntity = findUserByEmail(email);
                        if (userEntity != null) {
                            return userEntity;
                        }
                    } else {
                        return null;
                    }
                }
            } else {
                logger.error("Authorization value is not in the required format");
            }
        } catch (Exception e) {
            logger.error("Incorrect Bearer Token or Format", e);
        }
        return null;
    }


}
