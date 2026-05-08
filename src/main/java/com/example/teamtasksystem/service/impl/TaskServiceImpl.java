package com.example.teamtasksystem.service.impl;

import com.example.teamtasksystem.dto.TaskAssignRequest;
import com.example.teamtasksystem.dto.TaskCreateRequest;
import com.example.teamtasksystem.dto.TaskResponse;
import com.example.teamtasksystem.dto.TaskStatusUpdateRequest;
import com.example.teamtasksystem.entity.Task;
import com.example.teamtasksystem.enums.TaskStatusEnum;
import com.example.teamtasksystem.mapper.TaskMapper;
import com.example.teamtasksystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;

    /**
     * 创建任务
     *
     * @param request 任务创建请求
     */
    @Override
    public void createTask(TaskCreateRequest request, Long currentUserId) {


        Task task = new Task();
        task.setProjectId(request.getProjectId());
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus("TODO");
        task.setDeadline(request.getDeadline());
        task.setCreatorId(currentUserId);
        task.setAssigneeId(request.getAssigneeId());
        taskMapper.insert(task);
    }

    /**
     * 列出任务
     *
     * @param projectId 项目ID
     * @param status    任务状态
     * @param priority  任务优先级
     * @return 任务列表
     */
    @Override
    public List<TaskResponse> listTasks(Long projectId, String status, String priority) {
        List<Task> tasks = taskMapper.selectList(projectId, status, priority);

        return tasks.stream().map(this::toResponse).toList();
    }

    /**
     * 更新任务状态
     *
     * @param request 任务状态更新请求
     */
    @Override
    public void updateStatus(TaskStatusUpdateRequest request) {
        taskMapper.updateStatus(request.getTaskId(), request.getStatus());
    }

    /**
     * 指派任务
     *
     * @param request 任务指派请求
     */
    @Override
    public void assignTask(TaskAssignRequest request) {
        taskMapper.updateAssignee(request.getTaskId(), request.getAssigneeId());
    }

    /**
     * 转换任务为响应对象
     *
     * @param task 任务
     * @return 任务响应对象
     */
    private TaskResponse toResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setProjectId(task.getProjectId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setPriority(task.getPriority());
        response.setStatus(task.getStatus());
        response.setDeadline(task.getDeadline());
        response.setCreatorId(task.getCreatorId());
        response.setAssigneeId(task.getAssigneeId());
        response.setCreateTime(task.getCreateTime());
        response.setUpdateTime(task.getUpdateTime());
        return response;
    }
}