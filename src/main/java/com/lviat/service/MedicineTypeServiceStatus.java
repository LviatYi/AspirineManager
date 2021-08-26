package com.lviat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Rooter
 * @version 1.0
 * @enumName MedicineServiceTypeStatus
 * @date 2021/8/26
 */
@Getter
@AllArgsConstructor
public enum MedicineTypeServiceStatus {
    /**
     * 未知错误.
     */
    UNKNOWN_ERROR(0, "Unknown error"),
    /**
     * 成功.
     */
    SUCCESSFUL(1, "Successfully"),
    /**
     * 指定药品类别已存在.
     */
    MEDICINE_TYPE_ALREADY_EXIST(2, "MedicineType already exist"),
    /**
     * 指定药品类别不存在.
     */
    MEDICINE_TYPE_NOT_EXIST(3, "MedicineType not exist");

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
