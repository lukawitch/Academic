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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/hello")
public class PushContents extends HttpServlet {


 
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int chk=Integer.parseInt((String)req.getParameter("optradio"));
	 String title=req.getParameter("title");
	 String contents=req.getParameter("contents");

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy");
		 String today = formatter.format(new java.util.Date());

	 int status=Integer.parseInt((String)req.getParameter("state"));
	 String deadline=req.getParameter("deadline");
	 Date dead = Date.valueOf(deadline);
	 HttpSession sess = req.getSession(false);
	 String name=sess.getAttribute("Name").toString();
	 String major=sess.getAttribute("major").toString();
	 String ff=sess.getAttribute("defalut").toString();
	 int postIndex=Integer.parseInt(ff)+1;;
	 PrintWriter out =resp.getWriter();
		String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		String id="maple";
		String pw="lukawitch1226";
		PreparedStatement ps =null;
		Connection con =null;
		Statement sta =null;
		ResultSet rs =null;
		String sql=null;
		sql="insert into project_test values(?,?,?,?,?,?,?)";
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
				ps.setString(2,name);
				ps.setString(3,today);
				ps.setString(4,protype);
				ps.setString(5,major);
				ps.setInt(6,status);
				ps.setInt(7,postIndex);
				ps.executeUpdate();
				System.out.println("데이터입력완료");
				resp.sendRedirect("contentsuccess.jsp");
		

			}catch(SQLException e){System.out.println(e);
			System.out.println("연결에러");}
	}
}
