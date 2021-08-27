package com.lviat.service;

import com.lviat.model.MedicineType;

import java.util.List;

public interface MedicineTypeService {
    public MedicineTypeServiceStatus addMedicineType(MedicineType medicineType);
    public MedicineTypeServiceStatus delMedicineType(long typeId);
    public MedicineTypeServiceStatus modifyMedicineType(MedicineType medicineType);
    public MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page, int size);
    public MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page);
}
