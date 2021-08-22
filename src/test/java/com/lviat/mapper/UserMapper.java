package com.lviat.mapper;

import com.lviat.model.User;

import java.util.List;

/**
 * User 表 Mapper.
 *
 * @author LviatYi
 * @version 1.0
 * @interfaceName UserMapper
 * @date 2021/8/21
 */
public interface UserMapper {
    /**
     * 获取所有用户.
     * @return 所有用户.
     */
    List<User> getUser();
}
