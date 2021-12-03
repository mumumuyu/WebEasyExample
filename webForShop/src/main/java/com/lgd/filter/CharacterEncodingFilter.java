package com.lgd.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lgd
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //写test会以下载文件
//        System.out.println("过滤器执行前");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
