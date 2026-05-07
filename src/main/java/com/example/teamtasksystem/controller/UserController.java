package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.UserInfoResponse;
import com.example.teamtasksystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result<UserInfoResponse> getUserInfo(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }
}