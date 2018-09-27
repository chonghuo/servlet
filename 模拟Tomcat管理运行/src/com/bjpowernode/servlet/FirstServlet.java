package com.bjpowernode.servlet;

import com.bjpowernode.utils.Servlet;

public class FirstServlet implements  Servlet{
	
	private String name ;
	private int age;

	@Override
	public void service() {
		System.out.println("first servlet is run ....");
		System.out.println("name = " + this.name + " age = " + this.age);
	}

	@Override
	public void init() {
		this.name = "mike";
		this.age = 24;
	}

	@Override
	public void destory() {
		System.out.println("关闭流");
	}

}
