package com.crud.crudPractice.global.security.jwt;

import com.crud.crudPractice.global.config.security.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final JwtProperties jwtProperties;
}
