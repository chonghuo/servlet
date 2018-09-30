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
	 *servletRequest 接口实现类由tomcat创建,
	 *
	 *
	 */

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
			//1读取请求参数值
//		    String num1 = request.getParameter("num1");
//		    String num2 = request.getParameter("num2");
		    //2计算
//		    int sum = Integer.valueOf(num1) + Integer.valueOf(num2);
            String[] names = request.getParameterValues("name");
		    for (int i = 0; i < names.length; i++) {
		    	response.setCharacterEncoding("GBK");
			    System.out.println(names[i]);			
			}
		
//		    response.setCharacterEncoding("GBK");
//		    //3获取输出流
//		    PrintWriter out = response.getWriter();
//		    out.write("本次运算的结果是:" + sum);
		
				
		
	}

}
