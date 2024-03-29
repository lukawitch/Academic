package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/after")
public class Modified_After extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int chk=Integer.parseInt((String)req.getParameter("optradio"));
	 String title=req.getParameter("title");
	 System.out.println(title);
	 String contents=req.getParameter("contents");
	 System.out.println(contents);
	 int status=Integer.parseInt((String)req.getParameter("state"));
	 System.out.println(status);
	 String deadline=req.getParameter("deadline");
	 Date dead = Date.valueOf(deadline);
	 HttpSession sess= req.getSession();
	 int postindex=(Integer)sess.getAttribute("postindex");
	 String name =(String)req.getAttribute("name");
	 PrintWriter out =resp.getWriter();
		String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		String id="maple";
		String pw="lukawitch1226";
		PreparedStatement ps =null;
		Connection con =null;
		Statement sta =null;
		ResultSet rs =null;
		String sql=null;
		sql="update project_test set projectname=?, protype=?, end=? where postindex=?";
		String protype="학술제";
		if(chk==1) {
			protype="학술제";
		}
		else if(chk==2) {
			protype="프로젝트";
		}
		else if(chk==3) {
			protype="졸업작품";
		}
		
			try{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con=DriverManager.getConnection(DB_URL,id,pw);
				System.out.println("연결완료");
				ps=con.prepareStatement(sql);
				ps.setString(1,title);
				ps.setString(2,protype);
				ps.setInt(3, status);			
				ps.setInt(4, postindex);	
				ps.executeUpdate();
				System.out.println("데이터입력완료");
				resp.sendRedirect("contentsuccess.jsp");
		

			}catch(SQLException e){System.out.println(e);
			System.out.println("연결에러");}
	}
}
