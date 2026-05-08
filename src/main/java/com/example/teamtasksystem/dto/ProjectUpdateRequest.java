package com.example.teamtasksystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectUpdateRequest {

    @NotBlank(message = "项目名称不能为空")
    private String name;

    private String description;
}