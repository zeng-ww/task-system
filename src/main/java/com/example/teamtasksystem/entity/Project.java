package com.example.teamtasksystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

//项目
@Data
public class Project {

    private Long id;

    private String name;

    private String description;

    private Long creatorId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}