package com.project.ISAM;


import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ListChange")
public class ListChange extends HttpServlet {
	
	int number;
	int prenext;
	int count;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num= req.getParameter("a");
		String pre = req.getParameter("b");
		String cnt = req.getParameter("c");
		number=Integer.parseInt(num);
		prenext=Integer.parseInt(pre);
		
		if(cnt!=null) {
		count=Integer.parseInt(cnt);
		prenext=count+prenext;}
		HttpSession sess= req.getSession(false);
		sess.setAttribute("number",number);
		sess.setAttribute("prenext",prenext);
		resp.sendRedirect("./index.jsp");
		
	}
	public int getNumber() {
		return number;
	}
	
	
}
