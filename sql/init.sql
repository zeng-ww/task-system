CREATE DATABASE IF NOT EXISTS task_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE task_system;

DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          username VARCHAR(50) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          nickname VARCHAR(50),
                          email VARCHAR(100),
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE project (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         description VARCHAR(500),
                         creator_id BIGINT NOT NULL,
                         create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                         update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE task (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      project_id BIGINT NOT NULL,
                      title VARCHAR(100) NOT NULL,
                      description VARCHAR(1000),
                      priority VARCHAR(20) NOT NULL,
                      status VARCHAR(20) NOT NULL DEFAULT 'TODO',
                      deadline DATETIME,
                      creator_id BIGINT NOT NULL,
                      assignee_id BIGINT,
                      create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                      update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);