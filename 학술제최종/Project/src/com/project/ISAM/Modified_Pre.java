package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modifiedpre")
public class Modified_Pre extends HttpServlet {
	Contents Post = new Contents();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setCharacterEncoding("UTF-8");
	 resp.setContentType("text/html; charset=UTF-8");
	 
	 String name=req.getParameter("a");
	 String project_name=req.getParameter("b");
	 
	 String id="maple";
	 String pw="lukawitch1226";
	 HttpSession sess = req.getSession(false);
	 String protype=(String)sess.getAttribute("Value");
	 String Id=(String)sess.getAttribute("id");
	 req.setCharacterEncoding("UTF-8");
	 resp.setContentType("text/html; charset=UTF-8");
	 String sql="select title,editer,content,STATUS,deadline,viewcount,postindex from post_test"+
	 " where editer='"+name+"'"+" AND title='"+project_name+"'";
	
	 PrintWriter out = resp.getWriter();
	try {
	
		 String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		 Connection con=DriverManager.getConnection(DB_URL,id,pw);
		Statement sta=con.createStatement();
		 ResultSet rs =sta.executeQuery(sql);
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 while(rs.next()){
			 Post.setProjectname(rs.getString(1));
			 Post.setName(rs.getString(2));
			 Post.setContent(rs.getString(3));
			 Post.setStatus(rs.getInt(4));
			 Post.setDeadline(rs.getDate(5));	
			 Post.setViewcount(rs.getInt(6));
			 Post.setPostindex(rs.getInt(7));
		 }

		 System.out.println(Post.getName());
		 sess.setAttribute("Post", Post);
		
			 resp.sendRedirect("editperson?a=modified");
		 
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("연결에러");
	}
}
}
