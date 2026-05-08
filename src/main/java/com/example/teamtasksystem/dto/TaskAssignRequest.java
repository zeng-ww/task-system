package com.example.teamtasksystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskAssignRequest {


    @NotNull(message = "被指派用户ID不能为空")
    private Long assigneeId;
}