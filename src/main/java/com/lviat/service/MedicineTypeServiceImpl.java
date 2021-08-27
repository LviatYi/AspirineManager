package com.lviat.service;

import com.github.pagehelper.PageHelper;
import com.lviat.mapper.MedicineTypeMapper;
import com.lviat.model.MedicineTypeExample;
import com.lviat.model.MedicineType;
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
 * @author Rooter
 * @version 1.0
 * @className MedicineTypeServiceImpl
 * @date 2021/8/26
 */

public class MedicineTypeServiceImpl implements MedicineTypeService {
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
    public MedicineTypeServiceStatus addMedicineType(MedicineType medicineType) {
        MedicineTypeServiceStatus status = MedicineTypeServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            MedicineTypeMapper mapper = session.getMapper(MedicineTypeMapper.class);

            if (status == MedicineTypeServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(medicineType.getTypeId()) != null) {
                status = MedicineTypeServiceStatus.MEDICINE_TYPE_ALREADY_EXIST;
            }
            if (status == MedicineTypeServiceStatus.SUCCESSFUL) {
                mapper.insert(medicineType);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineTypeServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineTypeServiceStatus delMedicineType(long typeId) {
        MedicineTypeServiceStatus status = MedicineTypeServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            MedicineTypeMapper mapper = session.getMapper(MedicineTypeMapper.class);

            if (status == MedicineTypeServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(typeId) != null) {
                status = MedicineTypeServiceStatus.MEDICINE_TYPE_NOT_EXIST;
            }
            if (status == MedicineTypeServiceStatus.SUCCESSFUL) {
                mapper.deleteByPrimaryKey(typeId);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineTypeServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineTypeServiceStatus modifyMedicineType(MedicineType medicineType) {
        MedicineTypeServiceStatus status = MedicineTypeServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            MedicineTypeMapper mapper = session.getMapper(MedicineTypeMapper.class);

            if (status == MedicineTypeServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(medicineType.getTypeId()) == null) {
                status = MedicineTypeServiceStatus.MEDICINE_TYPE_NOT_EXIST;
            }
            if (status == MedicineTypeServiceStatus.SUCCESSFUL) {
                mapper.updateByPrimaryKey(medicineType);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineTypeServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page,int size) {
        MedicineTypeServiceStatus status = MedicineTypeServiceStatus.SUCCESSFUL;
        List<MedicineType> result = new ArrayList<>();

        try {
            session = MybatisUtil.getSession();
            MedicineTypeMapper mapper = session.getMapper(MedicineTypeMapper.class);

            PageHelper.startPage(page, size);
            result = mapper.selectByExample(new MedicineTypeExample());

            medicineTypes.addAll(result);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = MedicineTypeServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public MedicineTypeServiceStatus getMedicineType(List<MedicineType> medicineTypes, int page) {
        return getMedicineType(medicineTypes, page, MAX_PAGE_SIZE);
    }
}
