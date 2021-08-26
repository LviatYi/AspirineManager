package com.lviat.service;

import com.github.pagehelper.PageHelper;
import com.lviat.mapper.ConsumerMapper;
import com.lviat.model.Consumer;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.dao.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import com.lviat.model.ConsumerExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Rooter
 * @version 0.1
 * @className ConsumerServiceImpl
 * @date 2021/8/26
 */
public class ConsumerServiceImpl implements ConsumerService {
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
    public ConsumerServiceStatus addConsumer(Consumer consumer) {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            if (status == ConsumerServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(consumer.getId()) != null) {
                status = ConsumerServiceStatus.CONSUMER_ALREADY_EXIST;
            }
            if (status == ConsumerServiceStatus.SUCCESSFUL) {
                mapper.insert(consumer);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public ConsumerServiceStatus delConsumer(long consumerId) {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            if (status == ConsumerServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(consumerId) != null) {
                status = ConsumerServiceStatus.CONSUMER_NOT_EXIST;
            }
            if (status == ConsumerServiceStatus.SUCCESSFUL) {
                mapper.deleteByPrimaryKey(consumerId);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public ConsumerServiceStatus getConsumer(Consumer consumer, long consumerId) {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;
        Consumer result = null;

        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            result = mapper.selectByPrimaryKey(consumerId);

            if (result != null) {
                consumer.setId(consumerId);
                consumer.setCitId(result.getCitId());
                consumer.setName(result.getName());
            } else {
                status = ConsumerServiceStatus.CONSUMER_NOT_EXIST;
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public ConsumerServiceStatus getConsumer(List<Consumer> consumers, int page, int size) {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;
        List<Consumer> result = new ArrayList<>();

        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            PageHelper.startPage(page, size);
            result = mapper.selectByExample(new ConsumerExample());

            consumers.addAll(result);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public ConsumerServiceStatus getConsumer(List<Consumer> consumers, int page) {
        return getConsumer(consumers, page, MAX_PAGE_SIZE);
    }

    @Override
    public ConsumerServiceStatus modifyConsumer(Consumer consumer) {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            if (status == ConsumerServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(consumer.getId()) == null) {
                status = ConsumerServiceStatus.CONSUMER_NOT_EXIST;
            }
            if (status == ConsumerServiceStatus.SUCCESSFUL) {
                mapper.updateByPrimaryKey(consumer);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public long getConsumerCount() {
        ConsumerServiceStatus status = ConsumerServiceStatus.SUCCESSFUL;
        long count = 0;
        try {
            session = MybatisUtil.getSession();
            ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);

            count = mapper.countByExample(new ConsumerExample());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = ConsumerServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return count;
    }
}

