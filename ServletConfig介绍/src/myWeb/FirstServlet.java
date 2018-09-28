package myWeb;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FirstServlet implements Servlet {
	
	public FirstServlet() {
		System.out.println("firstServlet 被创建了");
	}
	
	
	private String name;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.name = config.getInitParameter("param_name");
		
	}
    
	/**
	 * 这个方法相当于Java工程中的main方法,是程序的入口
	 * 所有的servlet实现累类,都是由tomcat通知 jvm 对其进行实例化,单例模式
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
			System.out.println("============");
			System.out.println(this);
	}

}
