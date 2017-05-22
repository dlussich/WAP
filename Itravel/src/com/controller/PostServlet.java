package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.ImageBean;
import com.bean.PostBean;
import com.bean.RegisterBean;
import com.dao.ImageDao;
import com.dao.PostDao;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
@MultipartConfig(maxFileSize = 16177216)
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Copying all the input parameters in to local variables
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		RegisterBean user = (RegisterBean) session.getAttribute("user");
		if (user==null) {	
			// NOT LOGIN
			response.sendRedirect("Index.jsp");
		} else {	
			int id_user = user.getId_user();
			String text_post = request.getParameter("text_post");
			String state = request.getParameter("state");
			System.out.println(state);
			String city = request.getParameter("city");
			int zip_code = 0;
			if (request.getParameter("zip_code") != null) {
				zip_code = Integer.parseInt(request.getParameter("zip_code"));

			}

			PostBean PostBean = new PostBean();
			// Using Java Beans - An easiest way to play with group of related
			// data
			PostBean.setText(text_post);
			PostBean.setUser(id_user);
			PostBean.setState(state);
			PostBean.setCity(city);
			PostBean.setZip_code(zip_code);

			PostDao PostDao = new PostDao();

			// The core Logic of the Registration application is present here.
			// We
			// are going to insert user data in to the database.
			int PostRegistered = PostDao.registerPost(PostBean);
			if (PostRegistered != -1) // On success, you can add the
										// image
			{
				ImageBean ImageBean = new ImageBean();
				PostBean.setPost(PostRegistered);
				// Using Java Beans - An easiest way to play with group of
				// related
				// data
				ImageBean.setPost(PostRegistered);

				Part part = request.getPart("image");
				long header = part.getSize();
				InputStream is = null;
				;
				if (header > 0) {
					is = part.getInputStream();
				}

				if (is != null) {

					ImageBean.setImage(is);

					ImageDao ImageDao = new ImageDao();

					// The core Logic of the Registration application is present
					// here.
					// We
					// are going to insert user data in to the database.
					int ImageRegistered = ImageDao.registerImage(ImageBean);
					if (ImageRegistered != -1) // On success, you can
												// display a
												// message to user on Home
												// page
					{
						ImageBean.setId_image(ImageRegistered);
						
						request.getServletContext().setAttribute("listreq", PostDao.listAllPost());
						
						response.sendRedirect("Index.jsp");

					} else // On Failure, display a meaningful message to the
							// User.
					{
						response.sendRedirect("Index.jsp");
					}
				} else {// no image but other ok
					
					request.getServletContext().setAttribute("listreq", PostDao.listAllPost());

					response.sendRedirect("Index.jsp");

				}
			} else // On Failure, display a meaningful message to the User.
			{
				response.sendRedirect("Index.jsp");
			}

		}
	}

}
