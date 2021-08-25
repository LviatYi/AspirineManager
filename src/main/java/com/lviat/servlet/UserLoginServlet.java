package com.lviat.servlet;

import com.lviat.model.User;
import com.lviat.service.UserServiceImpl;
import com.lviat.service.UserServiceStatus;
import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 用户登录后台.
 * 无权限.
 *
 * @author LviatYi
 * @version 1.0
 * @className UserLoginServlet
 * @date 2021/7/28
 */
@Slf4j
@WebServlet(name = "UserLoginServlet", urlPatterns = UrlText.URL_LOGIN + ".do")
public class UserLoginServlet extends HttpServlet {
    UserServiceImpl userService;

    public UserLoginServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceStatus status = UserServiceStatus.SUCCESSFUL;

        if (req.getParameter(RelationText.WEB_USER_ID) == null || req.getParameter(RelationText.WEB_USER_PASSWORD) == null) {
            status = UserServiceStatus.VERITY_NOT_PASS;
        } else {
            long userId = Long.parseLong(req.getParameter(RelationText.WEB_USER_ID));
            String password = req.getParameter(RelationText.WEB_USER_PASSWORD);

            status = userService.verifyPassword(userId, password);

            User loginUser = new User();
            if (status == UserServiceStatus.SUCCESSFUL) {
                status = userService.getUser(loginUser, userId);
            }

            if (status == UserServiceStatus.SUCCESSFUL) {
                resp.setHeader("token", TokenUtil.createToken(userId, loginUser.getRole()));

                HttpSession httpSession = req.getSession();

                httpSession.setAttribute(RelationText.WEB_USER_ID, loginUser.getId());
                httpSession.setAttribute(RelationText.WEB_USER_USERNAME, loginUser.getUsername());
                httpSession.setAttribute(RelationText.WEB_USER_NAME, loginUser.getUsername());
                httpSession.setAttribute(RelationText.WEB_USER_PHONE_NUM, loginUser.getPhoneNum());
                httpSession.setAttribute(RelationText.WEB_USER_ROLE, loginUser.getRole());
            }

            switch (status) {
                case UNKNOWN_ERROR:
                default:
                    /*
                     * TODO_LviatYi 提示前端错误信息.
                     * date 2021/8/25
                     */
                    break;
                case SUCCESSFUL:
                    log.info("User login.Id : " + userId);
                    resp.sendRedirect(UrlText.URL_LOGIN + ".jsp");
                case VERITY_NOT_PASS:
                    /*
                     * TODO_LviatYi 提示前端密码错误.
                     * date 2021/8/25
                     */
                    break;
            }
        }
    }
}
