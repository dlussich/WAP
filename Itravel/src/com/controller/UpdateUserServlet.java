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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id_user = request.getParameter("user_id");
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
		registerBean.setId_user(Integer.parseInt(id_user));
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
		
		
		// The core Logic of the Update User application is present here. We
		// are going to update user data in to the database.
		int userUpdated = registerDao.updateUser(registerBean);

		if (userUpdated != -1) // On success, you can display a
												// message to user on Home page
		{
			// registerBean.setId_user(userUpdated);
			System.out.println("update user "+ userUpdated);
			// set session as "user"
			
			request.getSession().setAttribute("user", registerBean);
			
			response.sendRedirect("Index.jsp");
			
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userUpdated);
			request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
		}
	}

}
