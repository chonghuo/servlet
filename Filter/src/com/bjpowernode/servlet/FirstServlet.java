package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 读取用户的年龄
		String age = request.getParameter("age");
		response.setCharacterEncoding("GBK");
		response.getWriter().write("欢迎您");
		System.out.println(age + "岁用户来访问");
	}

	
}
