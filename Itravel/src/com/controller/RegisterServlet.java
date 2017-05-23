package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Copying all the input parameters in to local variables
		String fullName = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String zipCode = request.getParameter("zipcode");
		String birthYear = request.getParameter("birthyear");
		String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		RegisterBean registerBean = new RegisterBean();
		// Using Java Beans - An easiest way to play with group of related data
		registerBean.setFullName(fullName);
		registerBean.setGender(gender);
		registerBean.setState(state);
		registerBean.setCity(city);
		registerBean.setStreet(street);
		registerBean.setZipCode(zipCode);
		registerBean.setBirthYear(birthYear);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setPassword(password);

		RegisterDao registerDao = new RegisterDao();
		
		

		// The core Logic of the Registration application is present here. We
		// are going to insert user data in to the database.
		int userRegistered = registerDao.registerUser(registerBean);

		if (userRegistered!=-1) // On success, you can display a
												// message to user on Home page
		{
			registerBean.setId_user(userRegistered);
			System.out.println("user in the register "+ userRegistered);
			// set session as "user"
			
			request.getSession().setAttribute("user", registerBean);
			
			response.sendRedirect("Index.jsp");
			
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
