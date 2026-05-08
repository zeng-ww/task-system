package com.example.teamtasksystem.controller;

import com.example.teamtasksystem.common.Result;
import com.example.teamtasksystem.config.JwtAuthenticationFilter;
import com.example.teamtasksystem.dto.TaskAssignRequest;
import com.example.teamtasksystem.dto.TaskCreateRequest;
import com.example.teamtasksystem.dto.TaskResponse;
import com.example.teamtasksystem.dto.TaskStatusUpdateRequest;
import com.example.teamtasksystem.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * 创建任务
     *
     * @param request 任务创建请求
     * @return 创建结果
     */
    @PostMapping
    public Result<Void> createTask(@RequestBody @Valid TaskCreateRequest request,
                                   HttpServletRequest httpServletRequest) {
        Long currentUserId = (Long) httpServletRequest.getAttribute(JwtAuthenticationFilter.CURRENT_USER_ID);
        taskService.createTask(request, currentUserId);
        return Result.success();
    }

    /**
     * 列出任务
     *
     * @param projectId 项目ID
     * @param status    任务状态
     * @param priority  任务优先级
     * @return 任务列表
     */
    @GetMapping
    public Result<List<TaskResponse>> listTasks(
            @RequestParam Long projectId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String priority
    ) {
        List<TaskResponse> list = taskService.listTasks(projectId, status, priority);
        return Result.success(list);
    }

    /**
     * 更新任务状态
     *
     * @param request 状态更新请求
     * @return 更新结果
     */
    @PutMapping("/status")
    public Result<Void> updateStatus(@RequestBody @Valid TaskStatusUpdateRequest request) {
        taskService.updateStatus(request);
        return Result.success();
    }

    /**
     * 指派任务
     *
     * @param request 指派请求
     * @return 指派结果
     */
    @PutMapping("/assign")
    public Result<Void> assignTask(@RequestBody @Valid TaskAssignRequest request) {
        taskService.assignTask(request);
        return Result.success();
    }
}