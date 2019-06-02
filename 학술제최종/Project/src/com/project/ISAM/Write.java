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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/write")
public class Write extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
	int chk=Integer.parseInt((String)req.getParameter("optradio"));
	 String title=req.getParameter("title");
	 String contents=req.getParameter("contents");
	 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
	 String today = formatter.format(new java.util.Date());
	 Date d = Date.valueOf(today);
	 int status=Integer.parseInt((String)req.getParameter("state"));
	 String deadline=req.getParameter("deadline");
	 Date dead = Date.valueOf(deadline);
	 HttpSession sess = req.getSession(false);
	 String name=sess.getAttribute("Name").toString();
	 System.out.println(name);
	 String ff=sess.getAttribute("defalut").toString();
	 System.out.println(sess.getAttribute("defalut"));
	 int postIndex=Integer.parseInt(ff)+1;
	 PrintWriter out =resp.getWriter();
		String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		String id="maple";
		String pw="lukawitch1226";
		PreparedStatement ps =null;
		Connection con =null;
		Statement sta =null;
		ResultSet rs =null;
		String sql=null;
		sql="insert into post_test values(?,?,?,?,?,?,?,?)";
		
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
				ps.setInt(1,postIndex);
				ps.setString(2,title);
				ps.setString(3,name);
				ps.setDate(4,d);
				ps.setString(5,contents);
				ps.setInt(6,chk);
				ps.setDate(7,dead);
				ps.setInt(8,status);
				ps.executeUpdate();
				System.out.println("데이터입력완료");
				 ServletContext sc = this.getServletContext();
				 RequestDispatcher dispatcher = sc.getRequestDispatcher("/hello");                         
				 dispatcher.forward(req, resp); 

		

			}catch(SQLException e){System.out.println(e);
			System.out.println("연결에러");}
		}
		
}

