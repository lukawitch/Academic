package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/editperson")
public class EditPerson extends HttpServlet {
	
	Member member = new Member();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id="maple";
		 String pw="lukawitch1226";
		 String a=req.getParameter("a");
		 HttpSession sess = req.getSession(false);
		 String Id=(String)sess.getAttribute("id");
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("text/html; charset=UTF-8");
		 String sql="select * from info_test where "+"id="+Id+"";
		
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
				 member.setName(rs.getString(1));
				 member.setId(rs.getString(2));
				 member.setPw(rs.getString(3));
				 member.setMajor(rs.getString(4));
				 member.setRole(rs.getString(5));
				 member.setTel(rs.getString(6));
				 member.setMail(rs.getString(7));
				 		 		
			 }
			 
			 sess.setAttribute("member", member);
			 if(a.equals("edit")) {
			 resp.sendRedirect("editpersonal.jsp");}
			 else if(a.equals("write")) {
				 resp.sendRedirect("Write.jsp");
			 }
			 else if(a.equals("modified")){
				 resp.sendRedirect("Modified.jsp");
			 }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("연결에러");
		}
	}
}
