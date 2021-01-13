package com.loando.userService.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loando.userService.dto.request.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.jsonwebtoken.*;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private Environment environment;

    public AuthenticationFilter(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            LoginRequestDTO loginRequestDTO = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword(), new ArrayList<>()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername();
        System.out.println(environment.getProperty("token.signing.key"));

        String token = Jwts.builder()
                .setSubject("123456789").setExpiration(new Date(System.currentTimeMillis() + 10000000L))
                .signWith(SignatureAlgorithm.HS256, environment.getProperty("token.signing.key"))
                .compact();

        response.addHeader("token", token);
    }
}

