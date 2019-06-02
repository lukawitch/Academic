package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/dataconnect")
public class DataConnect extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<data> dataes=new ArrayList<data>();
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String a = req.getParameter("g");
		String b="졸업작품";
		String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		String id="maple";
		String pw="lukawitch1226";
		PreparedStatement ps =null;
		Connection con =null;
		Statement sta =null;
		ResultSet rs =null;
		String sql=null;
		HttpSession sess = req.getSession(false);
	
		if(a.equals("Graduation")) {
			sess.setAttribute("Value","졸업작품");		
			b="졸업작품";
		}
		else if(a.equals("Academic")) {
			sess.setAttribute("Value","학술제");		
			b="학술제";
		}
		else if(a.equals("project")) {
			sess.setAttribute("Value","프로젝트");		
			b="프로젝트";
		}
		else {
			out.println("<script>alert('Error');location.href='index.jsp';</script>");
		}
		
		sql="select projectname,name,major,end from project_test where protype='"+b+"'";
		
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
			rs=ps.executeQuery();
			int h;
			while(rs.next()){
				data info = new data();
				info.setProjectName(rs.getString(1));			
				info.setname(rs.getString(2));
				info.setmajor(rs.getString(3));	
				h=rs.getInt(4);
				System.out.println(h);
				if(h==1) {
				info.setNow("진행중");}
				else if(h==2){
					info.setNow("완료");
				}
				 
				dataes.add(info);
				
			}
			
			if(sess.getAttribute("dataes")!=null) {
				sess.removeAttribute("dataes");
			}

			sess.setAttribute("dataes", dataes);
			resp.sendRedirect("index.jsp");

		}catch(SQLException e){System.out.println(e);
		System.out.println("연결에러");}
		
	}
}
