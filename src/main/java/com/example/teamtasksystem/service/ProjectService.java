package com.example.teamtasksystem.service;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.ProjectCreateRequest;
import com.example.teamtasksystem.dto.ProjectResponse;
import com.example.teamtasksystem.dto.ProjectUpdateRequest;

import java.util.List;

public interface ProjectService {

    Result<Void> createProject(ProjectCreateRequest request, Long currentUserId);

    Result<List<ProjectResponse>> listProjects();

    void deleteProject(Long projectId);

    void updateProject(Long projectId, ProjectUpdateRequest request);
}