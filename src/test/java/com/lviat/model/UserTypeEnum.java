package com.lviat.model;

import lombok.Getter;

/**
 * 用户类型 Flag 枚举类.
 *
 * @author LviatYi
 * @version 1.0
 * @enumName UserTypeEnum
 * @date 2021/8/21
 */
@Getter
public enum UserTypeEnum {
    /**
     * 管理员.
     */
    ADMIN(0, "admin"),
    VISITOR(1, "visitor");

    /**
     * 用户类型.
     */
    private final int userType;
    /**
     * 用户类型名称.
     */
    private final String typeName;

    UserTypeEnum(int userType, String typeName) {
        this.userType = userType;
        this.typeName = typeName;
    }
}
