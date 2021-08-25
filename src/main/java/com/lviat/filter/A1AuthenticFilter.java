package com.lviat.filter;


import com.lviat.util.authentic.TokenUtil;
import com.lviat.util.constant.text.RelationText;
import com.lviat.util.constant.text.UrlText;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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

        if (request.getRequestURI().contains(UrlText.URL_LOGIN)) {
            //放行登录请求
            filterChain.doFilter(request, response);
            return;
        }

        boolean verify = true;

        String userId = (String) request.getSession().getAttribute(RelationText.WEB_USER_ID);

        if (userId == null || "".equals(userId)) {
            verify = false;
        } else {
            if (!request.getRequestURI().contains("index.jsp")) {
                //从请求头中获取token
                String token = request.getHeader("token");
                if (token == null || "".equals(token)) {
                    verify = false;
                } else {
                    verify = TokenUtil.verifyToken(token, Integer.parseInt(userId));
                }
            }
        }

        if (!verify) {
            response.sendRedirect(UrlText.URL_LOGIN + ".jsp");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

