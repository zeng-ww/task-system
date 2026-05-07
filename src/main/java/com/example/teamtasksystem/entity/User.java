package com.example.teamtasksystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

// 用户
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}