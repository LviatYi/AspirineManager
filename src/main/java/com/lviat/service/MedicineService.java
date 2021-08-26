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
     * 增加药品.
     *
     * @param medicine 新增药品.
     * @return service status.
     */
    MedicineServiceStatus addMedicine(Medicine medicine);

    /**
     * 删除药品.
     *
     * @param medicineId 删除药品 id.
     * @return service status.
     */
    MedicineServiceStatus delMedicine(long medicineId);

    /**
     * 获取药品.
     *
     * @param medicine   传入形参 药品.
     * @param medicineId Medicine ID.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(Medicine medicine, long medicineId);

    /**
     * 获取所有药品.
     * 具有尾增特性.
     *
     * @param medicines 传入形参 药品.
     * @param page      分页页码.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(List<Medicine> medicines, int page);

    /**
     * 获取所有药品.
     * 具有尾增特性.
     *
     * @param medicines 传入形参 药品.
     * @param page      分页页码.
     * @param size      单页显示数量.
     * @return service status.
     */
    MedicineServiceStatus getMedicine(List<Medicine> medicines, int page, int size);

    /**
     * 修改药品信息.
     * 通过 medicine 指定药品对象.
     *
     * @param medicine 新的药品信息.
     * @return service status.
     */
    MedicineServiceStatus modifyMedicine(Medicine medicine);

    /**
     * 获取药品数量.
     *
     * @return 所有药品数量.
     */
    long getMedicineCount();
}
