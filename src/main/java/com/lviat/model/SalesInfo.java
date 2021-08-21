package com.lviat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 销售记录 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className SalesInfo
 * @date 2021/8/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesInfo {
    /**
     * 销售记录编号.
     */
    private int id;

    /**
     * 销售日期.
     */
    private Date salesDate;

    /**
     * 药品 ID.
     */
    private int medicineId;

    /**
     * 销售数量.
     */
    private int salesCount;

    /**
     * 付款额.
     */
    private float payment;

    /**
     * 消费者 ID.
     */
    private int consumerId;
}
