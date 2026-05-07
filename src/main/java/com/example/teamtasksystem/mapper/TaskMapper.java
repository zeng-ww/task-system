package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    // 插入任务
    int insert(Task task);

    // 根据id查询任务
    Task selectById(Long id);

    // 根据条件查询任务
    List<Task> selectByCondition(@Param("projectId") Long projectId,
                                 @Param("status") String status,
                                 @Param("priority") String priority);

    // 更新任务状态
    int updateStatus(@Param("id") Long id, @Param("status") String status);

    // 更新任务负责人
    int updateAssignee(@Param("id") Long id, @Param("assigneeId") Long assigneeId);
}