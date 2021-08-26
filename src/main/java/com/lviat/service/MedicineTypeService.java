package com.lviat.service;

import com.lviat.model.MedicineType;

/**
 * 药品类别 service.
 *
 * @author Rooter
 * @version 0.1
 * @interfaceName MedicineTypeService
 * @date 2021/8/26
 */

public interface MedicineTypeService {
    /**
     * 增加药品类别.
     *
     * @param medicineType 新增药品类别.
     * @return service status.
     */
    UserServiceStatus addMedicineType(MedicineType medicineType);

    /**
     * 删除药品类别.
     *
     * @param typeId 删除药品类别.
     * @return service status.
     */
    UserServiceStatus delMedicineType(long typeId);

    /**
     * 编辑药品类别.
     *
     * @param typeId 编辑药品类别.
     * @return service status.
     */
    UserServiceStatus modifyMedicineType(long typeId);

    /**
     * 查看药品类别.
     *
     * @param typeId 查看药品类别.
     * @return service status.
     */
    UserServiceStatus queryMedicineType(long typeId);
}
