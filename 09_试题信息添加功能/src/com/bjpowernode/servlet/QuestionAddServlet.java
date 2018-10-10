package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class QuestionAddServlet implements Servlet {

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
		    String name,age;
		    String sql="INSERT INTO STUDENT(name,age) VALUES(?,?)";
		    Connection con = null;
		    PreparedStatement ps = null;
		    res.setCharacterEncoding("GBK");
//		    PrintWriter out=res.getWriter();
		    
		    //1.读取浏览器发送的请求参数内容
		        name = req.getParameter("name");
		        age = req.getParameter("age");
		        int i = Integer.valueOf(age);
		    //2.通过JDBC技术将得到试题信息插入到数据库
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
			        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "root");
			        ps =con.prepareStatement(sql);
			        ps.setString(1, name);
			        ps.setInt(2, i);
			        ps.executeUpdate();
//			        out.write("添加试题成功!");
		        }catch(Exception ex){
		        	ex.printStackTrace();
//		        	out.write("添加试题失败!");
		        }finally{
		        	  if(ps!=null){
		        		  try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	  }
		        	  
		        	  if(con!=null){
		        		  try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	  }
		        	  
//		        	  out.close();
		        	HttpServletResponse response = (HttpServletResponse)res;  
		        	response.sendRedirect("http://localhost:8080/myWeb2/questionFind");
		        }
		        
		    //3.通知用户本次请求是否成功

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
