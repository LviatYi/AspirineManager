package com.lviat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Rooter
 * @version TODO_LviatYi
 * @className ConsumerServiceStatus
 * @date 2021/8/26
 */
@Getter
@AllArgsConstructor
public enum ConsumerServiceStatus {
    /**
     * 未知错误.
     */
    UNKNOWN_ERROR(0, "Unknown error"),
    /**
     * 成功.
     */
    SUCCESSFUL(1, "Successfully"),
    /**
     * 指定消费者已存在.
     */
    CONSUMER_ALREADY_EXIST(2, "Consumer already exist"),
    /**
     * 指定消费者不存在.
     */
    CONSUMER_NOT_EXIST(3, "Consumer not exist");

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