package com.example.teamtasksystem.service.impl;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.UserInfoResponse;
import com.example.teamtasksystem.entity.User;
import com.example.teamtasksystem.mapper.UserMapper;
import com.example.teamtasksystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public Result<UserInfoResponse> getUserInfo(Long id) {
        User user = userMapper.selectById(id);

        // 用户不存在
        if (user == null) {
            return Result.error(404, "用户不存在");
        }

        // 构建响应数据
        UserInfoResponse response = new UserInfoResponse(
                user.getId(),
                user.getUsername(),
                user.getNickname(),
                user.getEmail()
        );

        return Result.success(response);
    }
}