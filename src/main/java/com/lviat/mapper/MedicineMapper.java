package com.lviat.mapper;

import com.lviat.model.Medicine;
import com.lviat.model.MedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    long countByExample(MedicineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int deleteByExample(MedicineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int insert(Medicine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int insertSelective(Medicine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    List<Medicine> selectByExample(MedicineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    Medicine selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int updateByPrimaryKeySelective(Medicine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LVIATYI.ASPN_MEDICINE
     *
     * @mbg.generated Mon Aug 23 11:33:12 CST 2021
     */
    int updateByPrimaryKey(Medicine record);

    int updateInventoryCountToMinus(@Param("id")long id,@Param("minusCount") long    minusCount);
}