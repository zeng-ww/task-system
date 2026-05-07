package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.ProjectCreateRequest;
import com.example.teamtasksystem.dto.ProjectResponse;
import com.example.teamtasksystem.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /**
     * 创建项目
     *
     * @param request 项目创建请求
     * @return 创建结果
     */
    @PostMapping
    public Result<Void> createProject(@RequestBody @Valid ProjectCreateRequest request) {
        return projectService.createProject(request);
    }

    /**
     * 列出所有项目
     *
     * @return 项目列表
     */
    @GetMapping
    public Result<List<ProjectResponse>> listProjects() {
        return projectService.listProjects();
    }
}