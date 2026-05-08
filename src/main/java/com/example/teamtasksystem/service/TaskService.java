package com.example.teamtasksystem.service;

import com.example.teamtasksystem.dto.TaskAssignRequest;
import com.example.teamtasksystem.dto.TaskCreateRequest;
import com.example.teamtasksystem.dto.TaskResponse;
import com.example.teamtasksystem.dto.TaskStatusUpdateRequest;

import java.util.List;

public interface TaskService {

    void createTask(TaskCreateRequest request, Long currentUserId);

    List<TaskResponse> listTasks(Long projectId, String status, String priority);

    void updateStatus(TaskStatusUpdateRequest request);

    void assignTask(TaskAssignRequest request);
}