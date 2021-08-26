package com.lviat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端信息类.
 *
 * @author LviatYi
 * @version 1.0
 * @className Message
 * @date 2021/8/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String message;
    int statusCode;
}