package com.example.teamtasksystem.service.impl;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.ProjectCreateRequest;
import com.example.teamtasksystem.dto.ProjectResponse;
import com.example.teamtasksystem.entity.Project;
import com.example.teamtasksystem.mapper.ProjectMapper;
import com.example.teamtasksystem.mapper.UserMapper;
import com.example.teamtasksystem.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    private final UserMapper userMapper;

    /**
     * 创建项目
     *
     * @param request 项目创建请求
     * @return 创建结果
     */
    @Override
    public Result<Void> createProject(ProjectCreateRequest request, Long currentUserId) {
        if (currentUserId == null) {
            return Result.error(401, "请先登录");
        }

        if (userMapper.selectById(currentUserId) == null) {
            return Result.error(404, "当前用户不存在");
        }

        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setCreatorId(currentUserId);

        projectMapper.insert(project);

        return Result.success();
    }

    /**
     * 列出所有项目
     *
     * @return 项目列表
     */
    @Override
    public Result<List<ProjectResponse>> listProjects() {
        List<Project> projects = projectMapper.selectAll();

        List<ProjectResponse> responses = projects.stream()
                .map(project -> new ProjectResponse(
                        project.getId(),
                        project.getName(),
                        project.getDescription(),
                        project.getCreatorId(),
                        project.getCreateTime()
                ))
                .toList();

        return Result.success(responses);
    }
}