package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {

    int insert(Task task);

    Task selectById(Long id);

    List<Task> selectList(
            @Param("projectId") Long projectId,
            @Param("status") String status,
            @Param("priority") String priority
    );

    int updateStatus(
            @Param("id") Long id,
            @Param("status") String status
    );

    // TaskMapper.java
    int assignTask(@Param("id") Long id, @Param("assigneeId") Long assigneeId);

    int deleteById(Long id);

    int deleteByProjectId(Long projectId);

    int updateById(Task task);
}