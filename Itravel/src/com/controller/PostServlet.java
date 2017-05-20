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
import javax.servlet.http.Part;

import com.bean.ImageBean;
import com.bean.PostBean;
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
		int id_user = 1;

		String text_post = request.getParameter("text_post");
		String location = request.getParameter("location");

		PostBean PostBean = new PostBean();
		// Using Java Beans - An easiest way to play with group of related data
		PostBean.setText(text_post);
		PostBean.setUser(id_user);
		PostBean.setLocation(location);

		PostDao PostDao = new PostDao();

		// The core Logic of the Registration application is present here. We
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
				InputStream is = null; ;
				  if(header>0){
		                is =  part.getInputStream();
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

					request.setAttribute("listreq", PostDao.listAllPost());

					request.setAttribute("message", "Image Uploaded");
					RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
					view.forward(request, response);

				} else // On Failure, display a meaningful message to the User.
				{
					response.sendRedirect("Index.jsp?message=Some+Error+Occurred");
				}
			} else {// no image but other ok
				request.setAttribute("listreq", PostDao.listAllPost());

				request.setAttribute("message", "Image Uploaded");
				RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
				view.forward(request, response);

			}
		} else // On Failure, display a meaningful message to the User.
		{
			response.sendRedirect("Index.jsp?message=Some+Error+Occurred");
		}

	}

}
