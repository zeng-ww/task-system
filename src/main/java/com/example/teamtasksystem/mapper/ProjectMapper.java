package com.example.teamtasksystem.mapper;

import com.example.teamtasksystem.entity.Project;

import java.util.List;

public interface ProjectMapper {

    int insert(Project project);

    Project selectById(Long id);

    List<Project> selectAll();
}