package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		RegisterBean RegisterBean= new RegisterBean();
		RegisterDao RegisterDao = new RegisterDao();

		// The core Logic of the Registration application is present here.
		RegisterBean RegisterBean_DB = RegisterDao.CheckUser(username);
		if(RegisterBean_DB.getFullName()!=null){// exist the user in the database
			if(RegisterBean_DB.getPassword().equals(password)){// the password is the same
				System.out.println("LOGIN OK");
				request.getSession().setAttribute("user", RegisterBean_DB);
				response.sendRedirect("Index.jsp");
			}
			else{
				request.setAttribute("errMessage", "the password is not correct");
				request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
			}
			
		}else{
			
			request.setAttribute("errMessage", "the user no exist in the database");
			request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
			
		}
		
		
//		
//		
//		
//		
//		
//		
//		
//		
//		response.setContentType("text/html");
//		
//		PrintWriter out = response.getWriter();
//		String title = "Using GET Method to Read Form Data";
//
//		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
//
//		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
//				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
//				+ "  <li><b>First Name</b>: " + request.getParameter("user_name") + "\n" + "  <li><b>Last Name</b>: "
//				+ request.getParameter("password") + "\n" + "</ul>\n" + "</body></html>");
//		out.close();
	}

}
