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
public class LoginServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        /**
         * 登陆账号密码 root：123456
         */


        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("root".equals(username) && "123456".equals(password)){

            HttpServletRequest request = (HttpServletRequest)req;

            HttpSession session = request.getSession();

            session.setAttribute("用户","mike");
            req.getRequestDispatcher("/project").forward(req,res);
        }else {
            req.getRequestDispatcher("login.html").forward(req,res);

        }


    }
}
