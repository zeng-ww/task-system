package com.example.teamtasksystem.service;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.LoginRequest;
import com.example.teamtasksystem.dto.LoginResponse;
import com.example.teamtasksystem.dto.RegisterRequest;

public interface AuthService {

    // 注册
    Result<Void> register(RegisterRequest request);

    // 登录
    Result<LoginResponse> login(LoginRequest request);
}