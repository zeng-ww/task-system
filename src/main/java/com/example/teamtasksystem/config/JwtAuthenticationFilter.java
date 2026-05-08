package com.example.teamtasksystem.config;

import com.example.teamtasksystem.common.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * JWT认证过滤器
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public static final String CURRENT_USER_ID = "currentUserId";
    public static final String CURRENT_USERNAME = "currentUsername";

    /**
     * 拦截所有请求，对请求头中的Authorization字段进行解析，获取用户ID和用户名，并设置到request中
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        // 判断请求头中是否包含Authorization字段，并且字段值以Bearer开头
        if (authorization != null && authorization.startsWith("Bearer ")) {
            // 获取token
            String token = authorization.substring(7);

            try {
                // 解析token
                Claims claims = jwtUtil.parseToken(token);

                // 获取用户ID和用户名
                Long userId = Long.valueOf(claims.get("userId").toString());
                String username = claims.get("username", String.class);

                // 设置用户ID和用户名到request中
                request.setAttribute(CURRENT_USER_ID, userId);
                request.setAttribute(CURRENT_USERNAME, username);

                // 创建UsernamePasswordAuthenticationToken对象，并设置到SecurityContextHolder中
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // token无效或已过期
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":401,\"message\":\"token无效或已过期\",\"data\":null}");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}