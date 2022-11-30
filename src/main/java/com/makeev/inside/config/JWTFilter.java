package com.makeev.inside.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.makeev.inside.security.JWTUtil;
import com.makeev.inside.service.AuthorDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;
    private final AuthorDetailsService authorDetailsService;
    @Autowired
    public JWTFilter(JWTUtil jwtUtil, AuthorDetailsService authorDetailsService) {
        this.jwtUtil = jwtUtil;
        this.authorDetailsService = authorDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer_")){
            String jwt = authHeader.substring(7);

            if(jwt.isBlank()){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT token");
            } else {
                try{
                    String username = jwtUtil.validateToken(jwt);
                    UserDetails userDetails = authorDetailsService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken token =
                            new UsernamePasswordAuthenticationToken(userDetails,
                                    userDetails.getPassword(),
                                    userDetails.getAuthorities());

                    if(SecurityContextHolder.getContext().getAuthentication() == null){
                        SecurityContextHolder.getContext().setAuthentication(token);
                    }

                }catch (JWTVerificationException exc){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
            }

            }
            filterChain.doFilter(request,response);
        }
    }

