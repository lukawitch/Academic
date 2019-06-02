package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet("/personupdate")
public class MemberUpdate extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			String number=req.getParameter("number");
			String password=req.getParameter("password");
			String password_check=req.getParameter("password_check");
			String major=req.getParameter("major");
			String role=req.getParameter("role");
			String phone=req.getParameter("phone");
			String email=req.getParameter("email");
			PrintWriter out =resp.getWriter();
			String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
			String id="maple";
			String pw="lukawitch1226";
			PreparedStatement ps =null;
			Connection con =null;
			Statement sta =null;
			ResultSet rs =null;
			String sql=null;
			sql="update info_test set pass=?, major=?,role=?, tel=?, mail=? where id=?";
			
			if(password.equals(password_check)) {
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
					ps.setString(1,password);
					ps.setString(2,major);
					ps.setString(3,role);
					ps.setString(4,phone);
					ps.setString(5,email);
					ps.setString(6,number);;
					ps.executeUpdate();
					System.out.println("데이터입력완료");
					resp.sendRedirect("editsuccess.jsp");
			

				}catch(SQLException e){System.out.println(e);
				System.out.println("연결에러");}
			}
			else {
				 out.println("<script>alert('비밀번호 확인을 다시해주세요');location.href='join.jsp';</script>");
		}
		}
}
