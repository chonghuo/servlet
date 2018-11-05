package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UncleFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取用户的年龄
		 String home = request.getParameter("home");
		 //判断用户的年龄
		 if(Integer.valueOf(home)<=200) {
			//非法请求,由过滤终止本次请求
			 response.setCharacterEncoding("GBK");
			 response.getWriter().write("不可以");
		 }else {//合法请求.将拦截[request]和[response]输送给目标文件
			 chain.doFilter(request, response);
		 }		
	}

}
