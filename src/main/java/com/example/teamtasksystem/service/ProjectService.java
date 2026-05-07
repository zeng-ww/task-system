package com.example.teamtasksystem.service;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.dto.ProjectCreateRequest;
import com.example.teamtasksystem.dto.ProjectResponse;

import java.util.List;

public interface ProjectService {

    Result<Void> createProject(ProjectCreateRequest request);

    Result<List<ProjectResponse>> listProjects();
}