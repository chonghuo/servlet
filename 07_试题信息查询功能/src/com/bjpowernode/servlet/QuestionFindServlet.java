package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuestionFindServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		          Connection channel;
		          PreparedStatement ps;
		          ResultSet rs;
		          String sql = "select * from student";
		          PrintWriter out= res.getWriter();
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
			        channel= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "root");
			        ps =channel.prepareStatement(sql);
			        rs=ps.executeQuery(); //存放servlet程序运行结果
			        out.write("<center>");
			        out.write("<table border='2'>");
			        while(rs.next()){
			        	out.write("<tr>");
			        	int id= rs.getInt("id");//试题编号
			        	String name=rs.getString("name");//试题题目内容
			        	int age = rs.getInt("age");
			        	out.write("<td>"+id+"</td>");
			        	out.write("<td>"+name+"</td>");
			        	out.write("<td>"+age+"</td>");
			        	out.write("</tr>");
                     }
			        out.write("</table>");
			        out.write("</center>");
			        
		        }catch(Exception ex){
		        	ex.printStackTrace();
		        }
		        

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
