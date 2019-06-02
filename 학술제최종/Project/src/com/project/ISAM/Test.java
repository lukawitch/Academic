package com.project.ISAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class Test extends HttpServlet {
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
	 String ff=sess.getAttribute("defalut").toString();
	 int postIndex=Integer.parseInt(ff);
	 PrintWriter out =resp.getWriter();

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy");
		 String today = formatter.format(new java.util.Date());
		 System.out.println(today);
	}
}
