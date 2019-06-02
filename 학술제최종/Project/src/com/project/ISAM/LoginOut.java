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


@WebServlet("/Loginout")
public class LoginOut extends HttpServlet {
	
	ArrayList<Member> members=new ArrayList<Member>();
	
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 String id="maple";
	 String pw="lukawitch1226";
	 String Id=req.getParameter("id");
	 String Pw=req.getParameter("pw");
	 req.setCharacterEncoding("UTF-8");
	 resp.setContentType("text/html; charset=UTF-8");
	 PrintWriter out = resp.getWriter();
	try {
	
		 String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		 Connection con=DriverManager.getConnection(DB_URL,id,pw);
		Statement sta=con.createStatement();
		 ResultSet rs =sta.executeQuery("select id,pass from info_test");
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 while(rs.next()){
			 Member member = new Member();
			 member.setId(rs.getString(1));
			 member.setPw(rs.getString(2));
			 members.add(member);			 		 		
		 }
		 int i;

		 
		 for(i=0;i<members.size();i++) {
			 if(Id.equals(members.get(i).getId())&&Pw.equals(members.get(i).getPw())) {
				 HttpSession sess =req.getSession(false);
				 sess.setAttribute("id",Id);
				 sess.setAttribute("pwd",Pw);
				 
				 out.println("<script>alert('로그인을 완료했습니다');location.href='index.jsp';</script>");
			 }
		 }
		 if(members.size()==i) {
			 out.println("<script>alert('ID와 비밀번호가 존재하지 않습니다.');location.href='login.jsp';</script>");
		 }
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("연결에러");
	}
	 
}
 
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		 HttpSession sess =req.getSession(false);
		 if(sess==null||sess.getAttribute("id")==null) {
			 out.println("<script>alert('부정한 경로로 접속하셨군요');location.href='index.jsp';</script>");
			 
		 }
		 else {
			 sess.invalidate();
			 out.println("<script>alert('로그아웃을 완료하였습니다');location.href='index.jsp';</script>");				
		 }
		 out.close();
}
}
