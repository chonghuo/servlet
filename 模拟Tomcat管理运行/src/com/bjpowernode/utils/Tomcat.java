package com.bjpowernode.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tomcat {
	
	
	public static void main(String[] args) throws  Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("/first", "com.bjpowernode.servlet.FirstServlet");
		System.out.println("tomcat 运行了");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要访问的路径");
		String path = sc.next();
		int size = path.lastIndexOf("/");
		String classPath = path.substring(size);
		Class<Servlet> classFile = (Class<Servlet>) Class.forName(map.get(classPath));
		Servlet first = classFile.newInstance();
		first.init();
		first.service();
		first.destory();
		
		
	}

}
