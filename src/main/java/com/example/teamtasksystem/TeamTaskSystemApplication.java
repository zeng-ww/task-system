package com.example.teamtasksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.teamtasksystem.mapper")
@SpringBootApplication
public class TeamTaskSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamTaskSystemApplication.class, args);
    }
}