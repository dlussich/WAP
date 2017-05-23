package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PostBean;
import com.dao.PostDao;

/**
 * Servlet implementation class LikesServlet
 */
@WebServlet("/LikesServlet")
public class LikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String par = request.getParameter("id_post");
		int id_post = 0;
		if (par != null) {
			id_post = Integer.parseInt(par);
		}
		//System.out.println("id_post  "+id_post);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		
		PostBean PostBean = new PostBean();
		PostBean.setPost(id_post);
		PostDao PostDao = new PostDao();

		// The core Logic of the Registration application is present here. 
		int PostLikes = PostDao.Selectlikes(PostBean);
		//System.out.println("PostLikes  "+PostLikes);
		
		if (PostLikes != -1) // On success, you can update the post
		{
			int new_likes = PostLikes + 1;
			// The core Logic of the Registration application is present here.
			// We
			// are going to insert user data in to the database.
			PostBean.setLikes(new_likes);

			int updatePostLikes = PostDao.Updatelikes(PostBean);
			//System.out.println("updatePostLikes   " + updatePostLikes);
			if (updatePostLikes != -1) // On success, you can update the post
			{
				response.getWriter().write(String.valueOf(new_likes));
				
			} else // On Failure, display a meaningful message to the User.
			{
				response.getWriter().write("-1");
			}
		} else // On Failure, display a meaningful message to the User.
		{
			response.getWriter().write("-1");
		}

	}

}
