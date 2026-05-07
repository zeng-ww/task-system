package com.example.teamtasksystem.service.impl;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.LoginRequest;
import com.example.teamtasksystem.dto.LoginResponse;
import com.example.teamtasksystem.dto.RegisterRequest;
import com.example.teamtasksystem.entity.User;
import com.example.teamtasksystem.mapper.UserMapper;
import com.example.teamtasksystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    // 注册, 用户名不能重复
    @Override
    public Result<Void> register(RegisterRequest request) {
        int count = userMapper.countByUsername(request.getUsername());
        if (count > 0) {
            return Result.error(400, "用户名已存在");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getNickname());
        user.setEmail(request.getEmail());

        userMapper.insert(user);

        return Result.success();
    }

    // 登录, 用户名不存在或密码错误
    @Override
    public Result<LoginResponse> login(LoginRequest request) {
        User user = userMapper.selectByUsername(request.getUsername());

        if (user == null) {
            return Result.error(400, "用户名或密码错误");
        }

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!matches) {
            return Result.error(400, "用户名或密码错误");
        }

        LoginResponse response = new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getNickname()
        );

        return Result.success(response);
    }
}