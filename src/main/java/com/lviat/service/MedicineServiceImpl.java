package com.lviat.service;

import com.github.pagehelper.PageHelper;
import com.lviat.mapper.MedicineMapper;
import com.lviat.mapper.MedicineMapper;
import com.lviat.model.Medicine;
import com.lviat.model.Medicine;
import com.lviat.model.MedicineExample;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.dao.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 药品 Service impl.
 *
 * @author LviatYi
 * @version 1.0
 * @className MedicineServiceImpl
 * @date 2021/8/26
 */
public class MedicineServiceImpl implements MedicineService {
    SqlSession session;
    private static final int MAX_PAGE_SIZE;

    //类加载时初始化.
    //从 token.config 配置文件中获取相关属性.
    static {
        boolean readStatus = true;
        Properties properties = new Properties();
        try {
            InputStream inputStream = TokenUtil.class.getClassLoader().getResourceAsStream("front.config");
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            readStatus = false;
        }
        if (readStatus) {
            MAX_PAGE_SIZE = Integer.parseInt(properties.getProperty("max_page_size"));
        } else {
            MAX_PAGE_SIZE = 30;
        }
    }

    @Override
    public MedicineServiceStatus addMedicine(Medicine medicine) {
        MedicineServiceStatus status = MedicineServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            MedicineMapper mapper = session.getMapper(MedicineMapper.class);

            if (status == MedicineServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(medicine.getId()) != null) {
                status = MedicineServiceStatus.MEDICINE_ALREADY_EXIST;
            }
            if (status == MedicineServiceStatus.SUCCESSFUL) {
                mapper.insert(medicine);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineServiceStatus delMedicine(long medicineId) {
        MedicineServiceStatus status = MedicineServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            MedicineMapper mapper = session.getMapper(MedicineMapper.class);

            if (status == MedicineServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(medicineId) != null) {
                status = MedicineServiceStatus.MEDICINE_NOT_EXIST;
            }
            if (status == MedicineServiceStatus.SUCCESSFUL) {
                mapper.deleteByPrimaryKey(medicineId);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineServiceStatus getMedicine(Medicine medicine, long medicineId) {
        MedicineServiceStatus status = MedicineServiceStatus.SUCCESSFUL;
        Medicine result = null;

        try {
            session = MybatisUtil.getSession();
            MedicineMapper mapper = session.getMapper(MedicineMapper.class);

            result = mapper.selectByPrimaryKey(medicineId);

            if (result != null) {
                medicine.setId(medicineId);
                medicine.setName(result.getName());
                medicine.setCode(result.getCode());
                medicine.setInventoryCount(result.getInventoryCount());
                medicine.setPrice(result.getPrice());
                medicine.setProductionDate(result.getProductionDate());
                medicine.setTypeId(result.getTypeId());
                medicine.setVendorName(result.getVendorName());
            } else {
                status = MedicineServiceStatus.MEDICINE_NOT_EXIST;
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineServiceStatus getMedicine(List<Medicine> medicines, int page, int size) {
        MedicineServiceStatus status = MedicineServiceStatus.SUCCESSFUL;
        List<Medicine> result = new ArrayList<>();

        try {
            session = MybatisUtil.getSession();
            MedicineMapper mapper = session.getMapper(MedicineMapper.class);

            PageHelper.startPage(page, size);
            result = mapper.selectByExample(new MedicineExample());

            medicines.addAll(result);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineServiceStatus getMedicine(List<Medicine> medicines, int page) {
        return getMedicine(medicines, page, MAX_PAGE_SIZE);
    }

    @Override
    public MedicineServiceStatus modifyMedicine(Medicine medicine) {
        return null;
    }

    @Override
    public long getMedicineCount() {
        MedicineServiceStatus status = MedicineServiceStatus.SUCCESSFUL;
        long count = 0;
        try {
            session = MybatisUtil.getSession();
            MedicineMapper mapper = session.getMapper(MedicineMapper.class);

            count = mapper.countByExample(new MedicineExample());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return count;
    }
}
