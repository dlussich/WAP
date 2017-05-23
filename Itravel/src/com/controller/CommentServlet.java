package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CommentBean;
import com.bean.PostBean;
import com.bean.RegisterBean;
import com.dao.CommentDao;
import com.dao.PostDao;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
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
		// TODO Auto-generated method stub
		String post = request.getParameter("id_post");
		String comment = request.getParameter("comment");
		HttpSession session = request.getSession(true);
		RegisterBean user = (RegisterBean) session.getAttribute("user");

		System.out.println(post);
		System.out.println(comment);
		
		int id_post = 0;
		if (post != null) {
			id_post = Integer.parseInt(post);
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		CommentBean CommentBean = new CommentBean();
		CommentBean.setPost(id_post);
		CommentBean.setComment(comment);
		CommentBean.setId_user(user);

		CommentDao CommentDao = new CommentDao();

		// The core Logic of the Registration application is present here.
		int comment_db = CommentDao.registerComment(CommentBean);
		if (comment_db != -1) {// all ok db
			response.getWriter().write("1");
		} else {
			response.getWriter().write("-1");
		}
	}

}
