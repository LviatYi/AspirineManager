package com.lviat.service;

import com.lviat.model.Medicine;

import java.util.List;

/**
 * 药品 Service.
 *
 * @author LviatYi
 * @version 1.0
 * @interfaceName MedicineService
 * @date 2021/8/26
 */
public interface MedicineService {
    /**
     * 增加用户.
     *
     * @param medicine 新增用户.
     * @return service status.
     */
    MedicineServiceStatus addMedicine(Medicine medicine);

    /**
     * 删除用户.
     *
     * @param medicineId 删除用户 id.
     * @return service status.
     */
    MedicineServiceStatus delMedicine(long medicineId);

    /**
     * 验证 token.
     *
     * @param medicineId 用户 id.
     * @param token  待验证 Token.
     * @param role   需要的 Role 权限.
     * @return service status.
     */
    MedicineServiceStatus verifyToken(long medicineId, String token, int role);

    /**
     * 验证密码.
     *
     * @param medicineId   用户 id.
     * @param password 待验证密码.
     * @return service status.
     */
    MedicineServiceStatus verifyPassword(long medicineId, String password);

    /**
     * 获取用户.
     *
     * @param medicine 传入形参 用户.
     * @param medicineId  Medicine ID.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(Medicine medicine, long medicineId);

    /**
     * 获取所有用户.
     * 具有尾增特性.
     *
     * @param medicines 传入形参 用户.
     * @param page  分页页码.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(List<Medicine> medicines, int page);

    /**
     * 获取所有用户.
     * 具有尾增特性.
     *
     * @param medicines 传入形参 用户.
     * @param page  分页页码.
     * @param size  单页显示数量.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(List<Medicine> medicines, int page, int size);

    /**
     * 获取用户数量.
     *
     * @return 所有用户数量.
     */
    long getMedicineCount();

    /**
     * 获取 token.
     * token 将包含 Role 与有效时间（默认为 24 小时）信息.
     * 若无此用户则返回 null.
     *
     * @param medicineId 申请者 id.
     */
    String getToken(long medicineId);
}
