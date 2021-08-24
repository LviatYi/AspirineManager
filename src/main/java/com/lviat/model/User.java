package com.lviat.model;


import lombok.*;

/**
 * 用户 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className User
 * @date 2021/8/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户 ID..
     */
    long id;

    /**
     * 用户名..
     */
    String username;

    /**
     * 密码.
     */
    String password;

    /**
     * 用户全名.
     */
    String name;

    /**
     * 电话号码.
     */
    String phoneNum;

    /**
     * 角色.
     */
    int role;
}
