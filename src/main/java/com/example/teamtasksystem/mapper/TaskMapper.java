package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    int insert(Task task);

    Task selectById(Long id);

    List<Task> selectByCondition(@Param("projectId") Long projectId,
                                 @Param("status") String status,
                                 @Param("priority") String priority);

    int updateStatus(@Param("id") Long id, @Param("status") String status);

    int updateAssignee(@Param("id") Long id, @Param("assigneeId") Long assigneeId);
}