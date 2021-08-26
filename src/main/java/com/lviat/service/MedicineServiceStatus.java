package com.lviat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Medicine Service Status.
 *
 * @author LviatYi
 * @version 1.0
 * @enumName MedicineServiceStatus
 * @date 2021/8/26
 */
@Getter
@AllArgsConstructor
public enum MedicineServiceStatus {
    /**
     * 未知错误.
     */
    UNKNOWN_ERROR(0, "Unknown error"),
    /**
     * 成功.
     */
    SUCCESSFUL(1, "Successfully"),
    /**
     * 指定药品已存在.
     */
    MEDICINE_ALREADY_EXIST(2, "Medicine already exist"),
    /**
     * 指定药品不存在.
     */
    MEDICINE_NOT_EXIST(3, "Medicine not exist");

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
