package com.example.teamtasksystem.service;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.LoginRequest;
import com.example.teamtasksystem.dto.LoginResponse;
import com.example.teamtasksystem.dto.RegisterRequest;

public interface AuthService {

    Result<Void> register(RegisterRequest request);

    Result<LoginResponse> login(LoginRequest request);
}