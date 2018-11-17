package com.tcredit.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Auther: chong.huo
 * Create  Date: 2018/11/17
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        //得到本次请求的资源路径
        HttpServletRequest req= (HttpServletRequest)request;
        String url = req.getRequestURI();

        //判断本次请求的资源路径与登陆是否相关
        if(url.indexOf("login") != -1){
            //与登陆相关，放行
            chain.doFilter(request,response);
        }else{
            //与登陆无关，需要进行验证处理，看其是否登陆
            HttpSession session =  req.getSession(false);
            if(session == null){
                //session 为空则是恶意登陆，跳转回登陆页面
                req.getRequestDispatcher("login.html").forward(request,response);
            }else if("mike".equals(session.getAttribute("用户"))){
                //session不为空，且验证正确，请求通过
                chain.doFilter(request,response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
