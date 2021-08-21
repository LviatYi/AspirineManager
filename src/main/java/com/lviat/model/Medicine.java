package com.lviat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 药品信息 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className Medicine
 * @date 2021/8/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    /**
     * 药品 ID.
     */
    private int id;

    /**
     * 药品编码.
     */
    private String code;

    /**
     * 药品名称.
     */
    private String name;

    /**
     * 药品单价.
     */
    private float price;

    /**
     * 库存数量.
     */
    private int inventoryCount;

    /**
     * 生产日期.
     */
    private Date productionDate;

    /**
     * 厂商.
     */
    private String vendorName;

    /**
     * 类别 ID.
     */
    private int typeId;
}
