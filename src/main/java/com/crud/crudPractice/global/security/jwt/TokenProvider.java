package com.crud.crudPractice.global.security.jwt;

import com.crud.crudPractice.global.config.security.jwt.JwtProperties;
import com.crud.crudPractice.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    private static final String ACCESS_TYPE = "access";
    private static final String REFRESH_TYPE = "refresh";
    private static final Long ACCESS_EXP = 60L * 10;
    private static final Long REFRESH_EXP = 60L * 60 * 24 * 7;
    private static final String TOKEN_PREFIX = "Bearer ";

    ZonedDateTime accessExpiredTime;

    public ZonedDateTime getAccessExpiredTime() {
        return ZonedDateTime.now().plusSeconds(ACCESS_EXP);
    }

    public String generateAccessToken(String email) {
        return generateToken(email, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP);
    }

    public String generateRefreshToken(String email) {
        return generateToken(email, REFRESH_TYPE, jwtProperties.refreshSecret, REFRESH_EXP);
    }

    public String generateToken(String sub, String type, Key secret, Long exp) {
        return Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(sub)
            .claim("type", type)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
            .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) return null;
        else return parseToken(token);
    }

    private String parseToken(String token) {
        if (token.startsWith(TOKEN_PREFIX))
            return token.replace(TOKEN_PREFIX, "");
        return null;
    }

    private Claims getTokenBody(String token, Key secret) {
        Claims claims;
        claims = Jwts.parserBuilder()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claims;
    }

    private String getTokenSubject(String token, Key secret) {
        return getTokenBody(token, secret).getSubject();
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.accessSecret));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
