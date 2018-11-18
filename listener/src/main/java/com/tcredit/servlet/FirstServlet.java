package com.tcredit.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Auther: chong.huo
 * Create  Date: 2018/11/17
 */
public class FirstServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


        ServletContext context = req.getServletContext();
        context.setAttribute("key",100);
        context.setAttribute("key",200);
        context.removeAttribute("key");
    }
}
