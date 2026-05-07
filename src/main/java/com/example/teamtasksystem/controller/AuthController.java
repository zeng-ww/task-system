package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.LoginRequest;
import com.example.teamtasksystem.dto.LoginResponse;
import com.example.teamtasksystem.dto.RegisterRequest;
import com.example.teamtasksystem.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 注册
     *
     * @param request 注册请求
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result<Void> register(@RequestBody @Valid RegisterRequest request) {
        return authService.register(request);
    }

    /**
     * 登录
     *
     * @param request 登录请求
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }
}