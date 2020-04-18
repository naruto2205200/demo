package com.example.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author naruto
 * @data 2018/11/27.
 */

public class HTTPBasicAuthorizeAttribute implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是自定义过滤器=======================");
    }

    @Override
    public void destroy() {

    }
}
