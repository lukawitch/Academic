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

@WebServlet("/read")
public class Read extends HttpServlet {
	Contents contents = new Contents();
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String id="maple";
	 String pw="lukawitch1226";
	 String name=req.getParameter("a");
	String pro=req.getParameter("b");
	 HttpSession sess = req.getSession(false);
	 String protype=(String)sess.getAttribute("Value");
	 String Id=(String)sess.getAttribute("id");
	 req.setCharacterEncoding("UTF-8");
	 resp.setContentType("text/html; charset=UTF-8");
	 String sql="select project_test.protype,post_test.deadline,project_test.projectname,post_test.content,project_test.name from project_test,post_test"+
	 " where project_test.name='"+name+"'"+" AND project_test.protype='"+protype+"'"+" AND project_test.projectname='"+pro+"'"+" AND project_test.postindex=post_test.postindex";
	
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
			 contents.setProtype(rs.getString(1));
			 contents.setDeadline(rs.getDate(2));
			 contents.setProjectname(rs.getString(3));
			 contents.setContent(rs.getString(4));
			 contents.setName(rs.getString(5));
			 		 		
		 }

		 
		 sess.setAttribute("contents", contents);
		
			 resp.sendRedirect("Read.jsp");
		 
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("연결에러");
	}
}
}
