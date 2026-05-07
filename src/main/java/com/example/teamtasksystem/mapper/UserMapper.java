package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.User;

public interface UserMapper {

    int insert(User user);

    User selectById(Long id);

    User selectByUsername(String username);

    int countByUsername(String username);
}