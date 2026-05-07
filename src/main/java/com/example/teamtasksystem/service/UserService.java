package com.example.teamtasksystem.service;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.UserInfoResponse;

public interface UserService {

    // 获取用户信息
    Result<UserInfoResponse> getUserInfo(Long id);
}