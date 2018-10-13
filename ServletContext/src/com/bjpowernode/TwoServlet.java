package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TwoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			String path = req.getParameter("path");
			ServletContext context = req.getServletContext();
			String realPath = context.getRealPath(path);
			System.out.println(realPath);
	}

}
