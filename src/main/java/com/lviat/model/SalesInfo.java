package com.lviat.model;

import lombok.*;

import java.util.Date;

/**
 * 销售记录 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className SalesInfo
 * @date 2021/8/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesInfo {
    /**
     * 销售记录 ID.
     */
    private long id;

    /**
     * 销售日期.
     */
    private Date salesDate;

    /**
     * 药品 ID.
     */
    private long medicineId;

    /**
     * 销售数量.
     */
    private long salesCount;

    /**
     * 付款额.
     */
    private float payment;

    /**
     * 消费者 ID.
     */
    private long consumerId;
}
