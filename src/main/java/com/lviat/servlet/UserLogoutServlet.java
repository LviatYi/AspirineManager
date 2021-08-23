//package com.lviat.servlet;
//
//import com.lviat.service.user.UserServiceImpl;
//import com.lviat.tool.constant.text.zh_cn.UrlText;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
///**
// * 用户登出后台.
// *
// * @author LviatYi
// * @version 1.0
// * @className UserLogoutServlet
// * @date 2021/7/31
// */
//@WebServlet(name = "UserLogoutServlet", urlPatterns = UrlText.URL_LOGOUT + ".do")
//public class UserLogoutServlet extends HttpServlet {
//
//    UserServiceImpl userService;
//
//    public UserLogoutServlet() {
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
//        HttpSession session = req.getSession();
//        if (session != null) {
//            session.invalidate();
//            resp.setHeader("token", "");
//        }
//
//        resp.sendRedirect("/login.jsp");
//    }
//}
