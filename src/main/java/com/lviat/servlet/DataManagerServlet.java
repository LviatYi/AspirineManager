package com.lviat.servlet;

import com.alibaba.fastjson.JSON;
import com.lviat.model.User;
import com.lviat.service.UserService;
import com.lviat.service.UserServiceImpl;
import com.lviat.service.UserServiceStatus;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 数据管理后台.
 * 管理员权限.
 *
 * @author LviatYi
 * @version 0.1
 * @className DateManagerServlet
 * @date 2021/8/26
 */
public class DataManagerServlet extends HttpServlet {
    private UserService userService;

    public DataManagerServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("method")) {
            case "user-add":
                User newUser = JSON.parseObject(req.getParameter("user"), User.class);
                userService.addUser(newUser);
            default:
                break;
        }
    }
}
