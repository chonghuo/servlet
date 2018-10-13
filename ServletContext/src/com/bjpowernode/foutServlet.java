package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class foutServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = (String) req.getAttribute("name");
		
		System.out.println("--"+name+"--");
		
		ServletContext context = req.getServletContext();
		int i  = (int) context.getAttribute("age");
			System.out.println(i);
	}

}
