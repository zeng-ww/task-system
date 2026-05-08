package com.example.teamtasksystem.service;

import com.example.teamtasksystem.dto.*;

import java.util.List;

public interface TaskService {

    void createTask(TaskCreateRequest request, Long currentUserId);

    List<TaskResponse> listTasks(Long projectId, String status, String priority);

    void updateStatus(Long id, TaskStatusUpdateRequest request);

    void assignTask(Long id, TaskAssignRequest request);

    void deleteTask(Long taskId);

    void updateTask(Long id, TaskUpdateRequest request);
}