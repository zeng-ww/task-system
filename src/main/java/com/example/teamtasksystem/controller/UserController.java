package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.config.JwtAuthenticationFilter;
import com.example.teamtasksystem.dto.UserInfoResponse;
import com.example.teamtasksystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    /**
     * 获取当前用户信息
     *
     * @param request 请求对象
     * @return 用户信息
     */
    @GetMapping("/me")
    public Result<UserInfoResponse> getCurrentUserInfo(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute(JwtAuthenticationFilter.CURRENT_USER_ID);

        if (userId == null) {
            return Result.error(401, "请先登录");
        }

        return userService.getUserInfo(userId);
    }
}