package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//向登陆用户索要私人数据
		String name = req.getParameter("name");
		String age  = req.getParameter("age");
		
		Cookie cookie1 = new Cookie("user_name",name);
		Cookie cookie2 = new Cookie("user_age",age);
		
		cookie1.setMaxAge(60);
		
		//将cookie偷偷送到用户浏览器shang
		HttpServletResponse response = (HttpServletResponse)res;
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		  

	}

}
