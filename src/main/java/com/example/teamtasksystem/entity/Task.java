package com.example.teamtasksystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

// 任务
@Data
public class Task {

    private Long id;

    private Long projectId;

    private String title;

    private String description;// 任务描述

    private String priority;// 任务优先级

    private String status;// 任务状态

    private LocalDateTime deadline;// 任务截止时间

    private Long creatorId;// 任务创建者

    private Long assigneeId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}