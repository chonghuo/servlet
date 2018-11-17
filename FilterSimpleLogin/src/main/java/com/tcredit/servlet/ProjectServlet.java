package com.tcredit.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Auther: chong.huo
 * Create  Date: 2018/11/16
 */
public class ProjectServlet extends GenericServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        if(session == null){
            res.setCharacterEncoding("GBK");
            res.getWriter().write("您没有登陆");
        }else if("mike".equals(session.getAttribute("用户"))){
            res.setCharacterEncoding("GBK");
            res.getWriter().write("欢迎来到：失乐园");
        }
    }
}
