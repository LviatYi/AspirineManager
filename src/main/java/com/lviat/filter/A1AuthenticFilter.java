package com.lviat.filter;


import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 用户认证过滤器.
 *
 * @author LviatYi
 * @version 0.1
 * @className AuthenticFilter
 * @date 2021/7/28
 */
@WebFilter(urlPatterns = "/*", filterName = "A1AuthenticFilter")
public class A1AuthenticFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        boolean verify = true;
        boolean isRelease = true;

        // 需要验证的 URL 所含关键字.
        List<String> verifyKey = Arrays.asList(
                ".do",
                ".jsp");
        List<String> releaseKey = Arrays.asList(
                "index.jsp",
                UrlText.LOGIN);

        for (String key : verifyKey) {
            if (url.contains(key)) {
                isRelease = false;
                break;
            }
        }
        for (String key : releaseKey) {
            if (url.contains(key)) {
                isRelease = true;
                break;
            }
        }

        if (isRelease) {
            //放行登录请求
            filterChain.doFilter(request, response);
            return;
        }

        Long userId = (Long) request.getSession().getAttribute(RelationText.WEB_USER_ID);

        //从请求头中获取 token
        Cookie[] cookies = request.getCookies();
        String token = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }
        if (userId == null || token == null || "".equals(token)) {
            verify = false;
        } else {
            verify = TokenUtil.verifyToken(token, userId);
        }

        if (!verify) {
            response.sendRedirect(UrlText.LOGIN + ".jsp");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

