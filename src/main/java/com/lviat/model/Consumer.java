package com.lviat.model;

import lombok.*;

/**
 * 消费者 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className Consumer
 * @date 2021/8/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {
    /**
     * 消费者.
     */
    private long id;

    /**
     * 姓名.
     */
    private String name;

    /**
     * 身份证号.
     */
    private String citId;
}