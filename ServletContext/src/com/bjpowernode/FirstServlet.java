package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		 //向Tomcat索要ServletContext对象
		 ServletConfig config = this.getServletConfig();
		 ServletContext context = config.getServletContext();
		 System.out.println(context);
		 //向Tomcat索要ServletContext对象
		 ServletContext  context2= this.getServletContext();
		 System.out.println(context2);
		 //向Tomcat索要ServletContext对象
		 ServletContext  context3 = req.getServletContext();
		 System.out.println(context3);
		 
		  

	}

}
