package com.emazon.ms_report.infra.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.emazon.ms_report.infra.exception.InvalidBearerTokenException;
import com.emazon.ms_report.infra.security.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private JwtUtils() {}

    private static String key;

    private static String userGenerator;

    @Value("${security.jwt.key.private}")
    public void setKey(String key){
        JwtUtils.key = key;
    }

    @Value("${security.jwt.user.generator}")
    public void setUserGenerator(String name){
        JwtUtils.userGenerator = name;
    }

    private static final String USER_ID = "userId";
    private static final String AUTHORITIES = "authorities";

    public static final Long PLUS_30_MINUTES = 1800000L;

    public static String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(key);

        CustomUserDetails userDetail = (CustomUserDetails) authentication.getPrincipal();

        Long userId = userDetail.getUserId();
        String username = authentication.getName();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return JWT.create()
                .withIssuer(userGenerator)
                .withSubject(username)
                .withClaim(AUTHORITIES, authorities)
                .withClaim(USER_ID, userId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + PLUS_30_MINUTES))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
    }

    public static DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(userGenerator)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new InvalidBearerTokenException();
        }
    }

    public static String getUsername(DecodedJWT decodedJWT){
        return decodedJWT.getSubject();
    }

    public static String getAuthorities(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim(AUTHORITIES).asString();
    }

    public static <T> T getClaimAs(String claim, DecodedJWT decodedJWT, Class<T> asClass) {
        return decodedJWT.getClaim(claim).as(asClass);
    }
}
