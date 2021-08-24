package com.lviat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User Service Status.
 *
 * @author LviatYi
 * @version 1.0
 * @enumName UserServiceStatus
 * @date 2021/8/23
 */
@Getter
@AllArgsConstructor
public enum UserServiceStatus {
    /**
     * 未知错误.
     */
    UNKNOWN_ERROR(0, "Unknown error"),
    /**
     * 成功.
     */
    SUCCESSFUL(1, "Successfully"),
    /**
     * 用户已存在.
     */
    USER_ALREADY_EXIST(2, "User already exist"),
    /**
     * 用户不存在.
     */
    USER_NOT_EXIST(3, "User not exist"),
    /**
     * 验证失败.
     */
    VERITY_NOT_PASS(4, "Verity not pass"),
    /**
     * 权限不足.
     */
    PERMISSION_DENIED(5, "Permission denied"),
    /**
     * 权限到期.
     */
    PERMISSION_EXPIRE(6, "Permission expire");

    /**
     * 状态码.
     */
    final private int status;
    /**
     * 描述.
     */
    final private String description;

    @Override
    public String toString() {
        return this.description;
    }

    public int value() {
        return this.status;
    }
}
