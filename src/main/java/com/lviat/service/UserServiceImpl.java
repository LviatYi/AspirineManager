package com.lviat.service;

import com.github.pagehelper.PageHelper;
import com.lviat.mapper.UserMapper;
import com.lviat.model.User;
import com.lviat.model.UserExample;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.dao.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * User Service impl.
 *
 * @author LviatYi
 * @version 1.0
 * @className UserServiceImpl
 * @date 2021/8/23
 */
@Slf4j
public class UserServiceImpl implements UserService {
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
    public UserServiceStatus addUser(User user) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            if (status == UserServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(user.getId()) != null) {
                status = UserServiceStatus.USER_ALREADY_EXIST;
            }
            if (status == UserServiceStatus.SUCCESSFUL) {
                mapper.insert(user);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public UserServiceStatus delUser(long userId) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            if (status == UserServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(userId) != null) {
                status = UserServiceStatus.USER_NOT_EXIST;
            }
            if (status == UserServiceStatus.SUCCESSFUL) {
                mapper.deleteByPrimaryKey(userId);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public UserServiceStatus verifyToken(long userId, String token, int role) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        try {
            switch (TokenUtil.verifyToken(token, userId, role)) {
                case 1:
                    break;
                case 2:
                    status = UserServiceStatus.PERMISSION_EXPIRE;
                    break;
                case 3:
                case 0:
                case 4:
                case 5:
                    status = UserServiceStatus.PERMISSION_DENIED;
                    break;
                default:
                    status = UserServiceStatus.UNKNOWN_ERROR;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
        }

        return status;
    }

    @Override
    public UserServiceStatus verifyPassword(long userId, String password) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectByPrimaryKey(userId);

            if (status == UserServiceStatus.SUCCESSFUL && user == null) {
                status = UserServiceStatus.USER_NOT_EXIST;
            }
            if (status == UserServiceStatus.SUCCESSFUL && !user.getPassword().equals(password)) {
                status = UserServiceStatus.VERITY_NOT_PASS;
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public UserServiceStatus getUser(User user, long userId) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;
        User result = null;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            result = mapper.selectByPrimaryKey(userId);

            if (result != null) {
                user.setId(userId);
                user.setName(result.getName());
                user.setUsername(result.getUsername());
                user.setRole(result.getRole());
                user.setPhoneNum(result.getPhoneNum());
            } else {
                status = UserServiceStatus.USER_NOT_EXIST;
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public UserServiceStatus getUser(List<User> users, int page, int size) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;
        List<User> result = new ArrayList<>();

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            PageHelper.startPage(page, size);
            result = mapper.selectByExample(new UserExample());

            users.addAll(result);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public UserServiceStatus getUser(List<User> users, int page) {
        return getUser(users, page, MAX_PAGE_SIZE);
    }

    @Override
    public long getUserCount() {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;
        long count = 0;
        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            count = mapper.countByExample(new UserExample());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return count;
    }

    @Override
    public UserServiceStatus modifyUser(User user) {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            if (status == UserServiceStatus.SUCCESSFUL && mapper.selectByPrimaryKey(user.getId()) == null) {
                status = UserServiceStatus.USER_NOT_EXIST;
            }
            if (status == UserServiceStatus.SUCCESSFUL) {
                mapper.updateByPrimaryKey(user);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            status = UserServiceStatus.UNKNOWN_ERROR;
            session.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public String getToken(long userId) {
        String token = null;

        try {
            session = MybatisUtil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);

            token = TokenUtil.createToken(userId, mapper.selectByPrimaryKey(userId).getRole());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }

        return token;
    }
}
