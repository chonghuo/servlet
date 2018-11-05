package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MotherFilter implements Filter{
	
	/*
	 * doFilter方法
	 * 1.进行拦截过滤的
	 * 2.用户每次发送请求时,doFilter方法被Tomcat调用一次
	 * 3.在用户每次把请求发送到Tomcat时,Tomcat会为本次请求生成[request]和
	 *   [response],在正常情况下Tomcat会将这对信息送到目标文件(Servlet)service 
	 *   如果有过滤器存在的时候,此时Tomcat将这对信息作为参数交给Filter实现类中doFilter
	 * 4.此时在doFilter方法,根据相关判断,决定本次请求是否可以到达目标文件,或则终止本次请求
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取用户的年龄
		 String sal = request.getParameter("sal");
		 //判断用户的年龄
		 if(Integer.valueOf(sal)<=20000) {
			//非法请求,由过滤终止本次请求
			 response.setCharacterEncoding("GBK");
			 response.getWriter().write("再去涨涨工资");
		 }else {//合法请求.将拦截[request]和[response]输送给目标文件
			 chain.doFilter(request, response);
		 }
	}

}
