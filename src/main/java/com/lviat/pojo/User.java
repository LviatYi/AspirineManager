package com.lviat.pojo;

import lombok.*;

/**
 * 用户 实体类.
 *
 * @author LviatYi
 * @version 1.0
 * @className User
 * @date 2021/8/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户 ID.
     */
    int userId;
    /**
     * 用户名.
     */
    String userName;
    /**
     * 密码
     */
    String password;
    /**
     * 用户全名
     */
    String userFullName;
    /**
     * 电话号码
     */
    String phoneNum;
    /**
     * 用户类型
     */
    int userType;
}
