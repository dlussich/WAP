package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CommentBean;
import com.dao.CommentDao;
import com.dao.PostDao;
import com.enums.State;
import com.google.gson.Gson;

/**
 * Servlet implementation class CommentListServlet
 */
@WebServlet("/CommentListServlet")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String par = request.getParameter("id_post");
		int id_post = 0;
		if (par != null) {
			id_post = Integer.parseInt(par);
		}
	
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		CommentDao CommentDao = new CommentDao();
		// The core Logic of the Registration application is present here. 
		List<CommentBean> ListComment=  CommentDao.listAllComment(id_post);
		String json = new Gson().toJson(ListComment);
		response.getWriter().write(json);
		
	}

}
