package com.lviat.service;

import com.lviat.model.User;

import java.util.List;

/**
 * 用户 service.
 *
 * @author LviatYi
 * @version TODO_LviatYi
 * @interfaceName UserService
 * @date 2021/8/23
 */
public interface UserService {
    /**
     * 增加用户.
     *
     * @param user 新增用户.
     * @return service status.
     */
    UserServiceStatus addUser(User user);

    /**
     * 删除用户.
     *
     * @param userId 删除用户 id.
     * @return service status.
     */
    UserServiceStatus delUser(long userId);

    /**
     * 验证 token.
     *
     * @param userId 用户 id.
     * @param token  待验证 Token.
     * @param role   需要的 Role 权限.
     * @return service status.
     */
    UserServiceStatus verifyToken(long userId, String token, int role);

    /**
     * 验证密码.
     *
     * @param userId   用户 id.
     * @param password 待验证密码.
     * @return service status.
     */
    UserServiceStatus verifyPassword(long userId, String password);

    /**
     * 获取所有用户.
     * 具有尾增特性.
     *
     * @param users 传入形参 用户.
     * @param page  分页页码.
     * @return service status.
     */
    UserServiceStatus getUser(List<User> users, int page);

    /**
     * 获取所有用户.
     * 具有尾增特性.
     *
     * @param users 传入形参 用户.
     * @param page  分页页码.
     * @param size  单页显示数量.
     * @return service status.
     */
    UserServiceStatus getUser(List<User> users, int page, int size);

    /**
     * 获取用户数量.
     *
     * @return 所有用户数量.
     */
    long getUserCount();

    /**
     * 获取 token.
     * token 将包含 Role 与有效时间（默认为 24 小时）信息.
     * 若无此用户则返回 null.
     *
     * @param userId 申请者 id.
     */
    String getToken(long userId);
}
