package com.cardgameproject.cardgame.filter;

import com.cardgameproject.cardgame.repository.UserRepository;
import com.cardgameproject.cardgame.util.JwtUtil;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public JwtFilter(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        // its coming from the request from the frontend
        // Our JWT will be prefixed with 'bearer'

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // If the header is empty we shortcut and do the reaming filter

        if (!StringUtils.hasText(header) || (StringUtils.hasText(header)
                && !header.startsWith("Bearer "))) {

            // If it's not a JWT just move on

            chain.doFilter(request, response);
            return;
        }

        // Get user identity and set it on the spring security context
        // Authorization(key) -> Bearer ...(the token as value)
        final String token = header.split(" ")[1].trim();
        UserDetails userDetails = userRepository
                .findByUsername(jwtUtil.getUsernameFromToken(token))
                .orElse(null);

        // Get jwt token and validate

        if (!jwtUtil.validateToken(token, userDetails)) {
            chain.doFilter(request, response);
            return;
        }


        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                        List.of() : userDetails.getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        // This is the stage where we inject the user

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    }


