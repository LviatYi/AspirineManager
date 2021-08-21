package com.lviat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 药品类型 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className MedicineType
 * @date 2021/8/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineType {
    /**
     * 类别 ID.
     */
    private int typeId;

    /**
     * 类别名称.
     */
    private String typeName;

    /**
     * 创建日期.
     */
    private Date createDate;

    /**
     * 类别描述.
     */
    private String comment;
}
