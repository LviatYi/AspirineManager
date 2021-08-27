package com.lviat.service;

import com.lviat.model.Medicine;
import com.lviat.model.MedicineType;

import java.util.List;

/**
 * 药品类别 service.
 *
 * @author Rooter
 * @version 1.0
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
    MedicineTypeServiceStatus addMedicineType(MedicineType medicineType);

    /**
     * 删除药品类别.
     *
     * @param typeId 删除药品类别.
     * @return service status.
     */
    MedicineTypeServiceStatus delMedicineType(long typeId);

    /**
     * 编辑药品类别.
     *
     * @param medicineType 编辑药品类别.
     * @return service status.
     */
    MedicineTypeServiceStatus modifyMedicineType(MedicineType medicineType);

    /**
     * 获取所有药品类别.
     * 具有尾增特性.
     *
     * @param medicineTypes 传入形参 药品.
     * @param page      分页页码.
     * @param size      单页显示数量.
     * @return service status.
     */
    MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page,int size);

    /**
     * 获取所有药品类别.
     * 具有尾增特性.
     *
     * @param medicineTypes 传入形参 药品.
     * @param page      分页页码.
     * @return service status.
     */
    MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page);
}
