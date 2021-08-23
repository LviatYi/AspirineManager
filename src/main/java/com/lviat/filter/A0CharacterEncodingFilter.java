package com.lviat.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

/**
 * 编码控制过滤器.
 *
 * @author LviatYi
 * @version 1.0
 * @className CharacterEncodingFilter
 * @date 2021/7/27
 */
@WebFilter(urlPatterns = "/*", filterName = "A0CharacterEncodingFilter", initParams = {
        @WebInitParam(name = "encoding", value = "utf-8")
})
public class A0CharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        servletResponse.setCharacterEncoding(filterConfig.getInitParameter("encoding"));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
