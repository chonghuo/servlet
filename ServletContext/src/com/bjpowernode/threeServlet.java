package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class threeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			ServletContext context = req.getServletContext();
			context.setAttribute("name", "mike");
			context.setAttribute("age", 18);
	}

}
