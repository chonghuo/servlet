package com.bjpowernode;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class TwoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		Cookie  array[] = request.getCookies();
		for (int i = 0; i < array.length; i++) {
			Cookie cookie = array[i];
			String name = cookie.getName();
			String age  = cookie.getValue();
			
			System.out.println("keyName" + name + "keyValue" + age  );
 		}
	}

}
