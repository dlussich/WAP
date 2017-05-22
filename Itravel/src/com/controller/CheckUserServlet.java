package com.controller;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("username");		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		RegisterDao registerDao = new RegisterDao();
		
		if (registerDao.CheckUser(user).getUserName() != null) {
			response.getWriter().write("-1");	// user name exist
		} else {
			response.getWriter().write("1");	// user name ok
		}
		
	}

}
