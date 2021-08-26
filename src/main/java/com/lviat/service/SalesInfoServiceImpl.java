package com.lviat.service;

import com.github.pagehelper.PageHelper;
import com.lviat.mapper.MedicineMapper;
import com.lviat.mapper.SalesInfoMapper;
import com.lviat.model.Medicine;
import com.lviat.model.SalesInfo;
import com.lviat.model.SalesInfoExample;
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
 * @version QwQ 1
 * @className SalesInfoServiceImpl
 * @date 2021/8/26
 */
public class SalesInfoServiceImpl implements SalesInfoService {
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
    public SalesInfoServiceStatus addSalesInfo(SalesInfo salesInfo) {
        SalesInfoServiceStatus status = SalesInfoServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();

            MedicineMapper medicineMapper = session.getMapper(MedicineMapper.class);
            SalesInfoMapper salesInfomapper = session.getMapper(SalesInfoMapper.class);

            if (status == SalesInfoServiceStatus.SUCCESSFUL) {
                salesInfomapper.insert(salesInfo);
                medicineMapper.updateInventoryCountToMinus(salesInfo.getId(),salesInfo.getSalesCount());
            }


            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = SalesInfoServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public SalesInfoServiceStatus delSalesInfo(long salesInfoId) {
        SalesInfoServiceStatus status = SalesInfoServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            SalesInfoMapper mapper = session.getMapper(SalesInfoMapper.class);

            if (status == SalesInfoServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(salesInfoId) != null) {
                status = SalesInfoServiceStatus.SALES_INFO_NOT_EXIST;
            }
            if (status == SalesInfoServiceStatus.SUCCESSFUL) {
                mapper.deleteByPrimaryKey(salesInfoId);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = SalesInfoServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public SalesInfoServiceStatus getSalesInfo(SalesInfo salesInfo, long salesInfoId) {
        SalesInfoServiceStatus status = SalesInfoServiceStatus.SUCCESSFUL;
        SalesInfo result = null;

        try {
            session = MybatisUtil.getSession();
            SalesInfoMapper mapper = session.getMapper(SalesInfoMapper.class);

            result = mapper.selectByPrimaryKey(salesInfoId);

            if (result != null) {
                salesInfo.setId(salesInfoId);
                salesInfo.setSalesDate(result.getSalesDate());
                salesInfo.setMedicineId(result.getMedicineId());
                salesInfo.setSalesCount(result.getSalesCount());
                salesInfo.setPayment(result.getPayment());
                salesInfo.setConsumerId(result.getConsumerId());
            } else {
                status = SalesInfoServiceStatus.SALES_INFO_NOT_EXIST;
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = SalesInfoServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public SalesInfoServiceStatus getSalesInfo(List<SalesInfo> salesInfos, int page, int size) {
        SalesInfoServiceStatus status = SalesInfoServiceStatus.SUCCESSFUL;
        List<SalesInfo> result = new ArrayList<>();

        try {
            session = MybatisUtil.getSession();
            SalesInfoMapper mapper = session.getMapper(SalesInfoMapper.class);

            PageHelper.startPage(page, size);
            result = mapper.selectByExample(new SalesInfoExample());

            salesInfos.addAll(result);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = SalesInfoServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public SalesInfoServiceStatus getSalesInfo(List<SalesInfo> salesInfos, int page) {
        return getSalesInfo(salesInfos, page, MAX_PAGE_SIZE);
    }

    @Override
    public SalesInfoServiceStatus modifySalesInfo(SalesInfo salesInfo) {
        return null;
    }

    @Override
    public long getSalesInfoCount() {
        SalesInfoServiceStatus status = SalesInfoServiceStatus.SUCCESSFUL;
        long count = 0;
        try {
            session = MybatisUtil.getSession();
            SalesInfoMapper mapper = session.getMapper(SalesInfoMapper.class);

            count = mapper.countByExample(new SalesInfoExample());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status =SalesInfoServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return count;
    }
}
