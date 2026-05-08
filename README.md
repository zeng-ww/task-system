
# 团队任务管理系统

## 项目概述

团队任务管理系统用于管理团队项目和任务，包括：

- 用户注册、登录和身份认证（JWT）
- 创建、修改、删除项目
- 创建、修改、删除任务
- 指派任务给成员
- 任务状态管理（TODO、DOING、DONE）
- 前端使用 Vue 3 + Element Plus + Pinia
- 后端使用 Spring Boot + MyBatis + MySQL

---

## 技术栈

### 后端

- Java 17+
- Spring Boot 3
- MyBatis
- MySQL 8+
- JWT Token 认证
- Maven 构建

### 前端

- Vue 3
- Element Plus
- Pinia
- Vite

---

## 快速开始

### 1. 克隆仓库

```bash
git clone https://github.com/zeng-ww/task-system.git
cd task-system
```
### 2. 配置数据库

- 创建数据库：
```
CREATE DATABASE task_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```
- 执行初始化 SQL：
```
mysql -u root -p task_system < sql/init.sql
```
- 修改数据库配置
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/task_system?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password: 你的数据库密码
 ```
### 3. 启动后端
后端接口地址：
http://localhost:8080
---

## 项目结构

### 后端结构（Spring Boot）

```
team-task-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/teamtasksystem/
│   │   │   ├── controller/      # 控制器层，处理 HTTP 请求
│   │   │   ├── dto/             # 数据传输对象
│   │   │   ├── entity/          # 实体类（数据库映射）
│   │   │   ├── mapper/          # MyBatis Mapper 接口
│   │   │   ├── service/         # 业务逻辑接口
│   │   │   ├── service/impl/    # 业务逻辑实现
│   │   │   └── common/          # 公共工具、返回结果类、分页封装等
│   │   └── resources/
│   │       ├── mapper/          # MyBatis XML 映射文件
│   │       ├── application.yml  # 配置文件
│   │       └── sql/             # 初始化数据库脚本 init.sql
├── pom.xml                        # Maven 配置文件
└── README.md                       # 项目说明文档
```

## 数据库设计

### 用户表（sys_user）

| 字段       | 类型        | 说明               |
| ---------- | --------- | ---------------- |
| id         | bigint    | 用户ID，自增主键   |
| username   | varchar   | 登录用户名         |
| password   | varchar   | 加密密码           |
| nickname   | varchar   | 昵称               |
| email      | varchar   | 邮箱               |
| createTime | datetime  | 创建时间           |

### 项目表（project）

| 字段       | 类型       | 说明                  |
| ---------- | -------- | ------------------- |
| id         | bigint   | 项目ID，自增主键       |
| name       | varchar  | 项目名称               |
| description| text     | 项目描述               |
| creatorId  | bigint   | 创建用户ID            |
| createTime | datetime | 创建时间               |

### 任务表（task）

| 字段       | 类型       | 说明                        |
| ---------- | -------- | ------------------------- |
| id         | bigint   | 任务ID，自增主键             |
| projectId  | bigint   | 所属项目ID                   |
| title      | varchar  | 任务标题                     |
| description| text     | 任务描述                     |
| priority   | varchar  | 优先级（LOW/MEDIUM/HIGH）   |
| status     | varchar  | 状态（TODO/DOING/DONE）     |
| deadline   | datetime | 截止时间                     |
| creatorId  | bigint   | 创建用户ID                   |
| assigneeId | bigint   | 指派用户ID                   |
| createTime | datetime | 创建时间                     |

---

## 后端接口说明

### 用户

| 接口                 | 方法 | 描述                      |
| -------------------- | ---- | ------------------------ |
| /api/auth/register    | POST | 用户注册                  |
| /api/auth/login       | POST | 用户登录，返回 JWT token   |
| /api/users/me         | GET  | 获取当前登录用户信息       |
| /api/users/{id}       | GET  | 获取指定用户信息           |

### 项目

| 接口                     | 方法 | 描述                     |
| ------------------------ | ---- | ----------------------- |
| /api/projects            | GET  | 查询项目列表（支持分页） |
| /api/projects            | POST | 创建项目                  |
| /api/projects/{id}       | PUT  | 修改项目                  |
| /api/projects/{id}       | DELETE | 删除项目                |

### 任务

| 接口                     | 方法 | 描述                           |
| ------------------------ | ---- | ----------------------------- |
| /api/tasks               | GET  | 查询任务列表（支持分页、筛选） |
| /api/tasks               | POST | 创建任务                        |
| /api/tasks/{id}          | PUT  | 修改任务                        |
| /api/tasks/{id}/status   | PUT  | 修改任务状态                     |
| /api/tasks/{id}/assign   | PUT  | 指派任务                        |
| /api/tasks/{id}          | DELETE | 删除任务                        |

---
## 功能说明
### 用户模块
- 用户注册：用户名、密码、昵称、邮箱
- 用户登录：JWT token 认证，登录后 token 存入 localStorage
- 路由守卫：无 token 时自动跳转登录页
- 退出登录：清除 token 和用户信息
### 项目模块
- 项目列表：展示所有项目（序号、ID、名称、描述、创建时间）
- 创建项目：弹窗表单，仅需填写名称和描述
- 编辑项目：修改项目名称和描述
- 删除项目：二次确认后删除
- 点击项目可进入对应任务管理页
### 任务模块
- 任务列表：序号、ID、标题、描述、优先级、状态、截止时间、创建者、指派用户
- 筛选：按状态（待办/进行中/已完成）和优先级（低/中/高）筛选
- 创建任务：标题、描述、优先级、截止时间、指派用户ID
- 编辑任务：修改标题、描述、优先级、截止时间、指派任务人
- 状态流转：待办 → 进行中 → 已完成
- 指派任务：修改任务指派用户
- 删除任务：二次确认后删除
### 统一规范
- 所有需要认证的请求自动携带 Authorization: Bearer <token>
- 后端返回 code !== 200 时自动弹出错误提示
- HTTP 401 时清除 token 并跳转登录页
- HTTP 403 时仅提示错误不跳转
---

## 项目地址

### Git 仓库

- 后端仓库：https://github.com/zeng-ww/task-system
- 前端仓库：https://github.com/zeng-ww/team-task-system-frontend

### 本地运行地址

- 后端接口地址：http://localhost:8080
- 前端页面地址：http://localhost:5173


