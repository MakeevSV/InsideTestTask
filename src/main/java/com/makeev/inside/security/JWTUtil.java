package com.makeev.inside.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt_secret}")
    private String secret;
    @Value("${jwt_expire_minutes}")
    private Long expireMinutes;


    public String generateToken(String username){
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(expireMinutes).toInstant());

        return JWT.create()
                .withSubject("Details")
                .withClaim("username", username)
                .withIssuer("inside")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateToken(String token) throws JWTVerificationException {


        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("Details")
                .withIssuer("inside")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("username").asString();
    }
}
