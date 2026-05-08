package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.Project;

import java.util.List;

public interface ProjectMapper {

    // 插入项目
    int insert(Project project);

    // 根据id查询项目
    Project selectById(Long id);

    // 查询所有项目
    List<Project> selectAll();

    // 根据id删除项目
    int deleteById(Long id);

    // 根据id更新项目
    int updateById(Project project);
}