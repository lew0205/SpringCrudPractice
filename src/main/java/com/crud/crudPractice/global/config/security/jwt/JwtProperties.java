package com.crud.crudPractice.global.config.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    public Key accessSecret;
    public Key refreshSecret;

    @Value("${jwt.accessSecret}")
    private String accessSecretValue;

    @Value("${jwt.refreshSecret}")
    private String refreshSecretValue;

    @PostConstruct
    public void init() {
        this.accessSecret = Keys.hmacShaKeyFor(accessSecretValue.getBytes(StandardCharsets.UTF_8));
        this.refreshSecret = Keys.hmacShaKeyFor(refreshSecretValue.getBytes(StandardCharsets.UTF_8));
    }
}