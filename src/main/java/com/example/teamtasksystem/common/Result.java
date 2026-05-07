package com.example.teamtasksystem.common;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 默认成功, 不返回数据
    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }

    // 成功, 返回数据
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    // 失败, 自定义错误信息
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // 失败, 自定义错误码和错误信息
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}