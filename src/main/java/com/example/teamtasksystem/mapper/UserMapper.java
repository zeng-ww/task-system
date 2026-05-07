package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.User;

public interface UserMapper {

    // 插入用户
    int insert(User user);

    // 根据id查询用户
    User selectById(Long id);

    // 根据用户名查询用户
    User selectByUsername(String username);

    // 根据用户名查询用户数量
    int countByUsername(String username);
}