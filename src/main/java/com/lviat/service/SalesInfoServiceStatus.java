package com.lviat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO_LviatYi
 *
 * @author LviatYi
 * @version QwQ 1
 * @enumName SalesInfoServiceStatus
 * @date 2021/8/26
 */
@Getter
@AllArgsConstructor
public enum SalesInfoServiceStatus {
    /**
     * 未知错误.
     */
    UNKNOWN_ERROR(0, "Unknown error"),
    /**
     * 成功.
     */
    SUCCESSFUL(1, "Successfully"),
    /**
     * 指定销售信息已存在.
     */
    SALES_INFO_ALREADY_EXIST(2, "SalesInfo already exist"),
    /**
     * 指定销售信息不存在.
     */
    SALES_INFO_NOT_EXIST(3, "SalesInfo not exist");

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
