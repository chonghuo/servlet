package myWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FirstServlet implements Servlet {
	
	public FirstServlet() {
		
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
	 * ServletResponse接口的实现类将后台运行结果输送给用户
	 * ServletResponse接口的实现类由tomcat创建 
	 * tomcat调用service方法时,将响应对象作为参数传入service方法,因此开发人员可以直接使用响应对象
	 * 可以通过响应对象得到字节输出流与字符输出流
	 * 将运行结果放入输出流中传递给前端
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse response) throws ServletException, IOException {
		String result = "hello world";
		String result2 = "你好中国";
		//设置字符集需要在创建输出流对象之前
		response.setCharacterEncoding("GBK");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.write(result2);
		writer.flush();
		writer.close();
		
				
		
	}

}
