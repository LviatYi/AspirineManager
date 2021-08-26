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
public enum RoleEnum {
    /**
     * 管理员.
     */
    ADMIN(1, "admin"),
    /**
     * 访问者.
     */
    VISITOR(2, "visitor");

    /**
     * 用户类型.
     */
    private final int userType;
    /**
     * 用户类型名称.
     */
    private final String typeName;

    RoleEnum(int userType, String typeName) {
        this.userType = userType;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return this.typeName;
    }

    public int value() {
        return this.userType;
    }
}
