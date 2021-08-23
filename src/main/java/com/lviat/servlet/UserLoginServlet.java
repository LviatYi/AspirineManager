//package com.lviat.servlet;
//
//import com.lviat.pojo.User;
//import com.lviat.service.user.UserServiceImpl;
//import com.lviat.tool.Token;
//import com.lviat.tool.constant.text.zh_cn.*;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
///**
// * 用户登录后台.
// * 无权限.
// *
// * @author LviatYi
// * @version 1.0
// * @className UserLoginServlet
// * @date 2021/7/28
// */
//@Slf4j
//@WebServlet(name = "UserLoginServlet", urlPatterns = UrlText.URL_LOGIN + ".do")
//public class UserLoginServlet extends HttpServlet {
//    UserServiceImpl userService;
//
//    public UserLoginServlet() {
//        userService = new UserServiceImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter(UserText.USER_ID) != null && req.getParameter(UserText.USER_PASSWORD) != null) {
//            int userId = Integer.parseInt(req.getParameter(UserText.USER_ID));
//            String password = req.getParameter(UserText.USER_PASSWORD);
//
//            if (userService.verifyPassword(userId, password)) {
//                userService.updateLastLoginTime(userId);
//
//                User loginUser = userService.getUser(userId);
//                resp.setHeader("token", Token.createToken(userId, loginUser.getAuthentic()));
//
//                HttpSession httpSession = req.getSession();
//                httpSession.setAttribute(UserText.USER_ID, String.valueOf(loginUser.getId()));
//                httpSession.setAttribute(UserText.USER_NAME, String.valueOf(loginUser.getUserName()));
//                httpSession.setAttribute(UserText.USER_LAST_LOGIN_TIME, String.valueOf(loginUser.getLastLoginTime()));
//                httpSession.setAttribute(UserText.USER_CREATE_TIME, String.valueOf(loginUser.getCreateTime()));
//
//                log.info("User login.Id : " + userId);
//                resp.sendRedirect("/index.jsp");
//                return;
//            }
//        }
//
//        /*
//        * TODO_LviatYi 建议只返回状态，不重定向.
//        * date 2021/8/1
//        */
//        req.setAttribute("error", MessageText.PASSWORD_ERROR);
//        resp.sendRedirect("/login.jsp");
//    }
//}
