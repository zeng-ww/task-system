package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.config.JwtAuthenticationFilter;
import com.example.teamtasksystem.dto.ProjectCreateRequest;
import com.example.teamtasksystem.dto.ProjectResponse;
import com.example.teamtasksystem.dto.ProjectUpdateRequest;
import com.example.teamtasksystem.service.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
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
    public Result<Void> createProject(@RequestBody @Valid ProjectCreateRequest request,
                                      HttpServletRequest httpServletRequest) {
        Long currentUserId = (Long) httpServletRequest.getAttribute(JwtAuthenticationFilter.CURRENT_USER_ID);
        return projectService.createProject(request, currentUserId);
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


    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @DeleteMapping("/{projectId}")
    public Result<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return Result.success();
    }

    /**
     * 修改项目
     *
     * @param id        项目ID
     * @param request   项目更新请求
     * @return 更新结果
     */
    @PutMapping("/{id}")
    public Result<Void> updateProject(@PathVariable Long id,
                                      @RequestBody @Valid ProjectUpdateRequest request) {
        projectService.updateProject(id, request);
        return Result.success();
    }
}