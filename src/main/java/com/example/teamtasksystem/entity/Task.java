package com.example.teamtasksystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {

    private Long id;

    private Long projectId;

    private String title;

    private String description;

    private String priority;

    private String status;

    private LocalDateTime deadline;

    private Long creatorId;

    private Long assigneeId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}