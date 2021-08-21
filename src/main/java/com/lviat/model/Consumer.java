package com.lviat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 消费者 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className Consumer
 * @date 2021/8/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {
    /**
     * 消费者.
     */
    private int id;

    /**
     * 姓名.
     */
    private String name;

    /**
     * 身份证号.
     */
    private String citId;
}
