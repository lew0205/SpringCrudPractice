package com.crud.crudPractice.global.security.jwt;

import com.crud.crudPractice.global.exception.BasicException;
import com.crud.crudPractice.global.exception.ErrorCode;
import com.crud.crudPractice.global.exception.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BasicException e) {
            sendError(response, e.getErrorCode());
        } catch (Exception e) {
            sendError(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendError(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse(errorCode);
        String responseString = objectMapper.writeValueAsString(errorResponse);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(errorCode.getCode());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(responseString);
    }
}
