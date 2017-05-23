package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CommentBean;
import com.bean.ImageBean;
import com.bean.PostBean;
import com.bean.RegisterBean;
import com.util.DBConnection;

public class CommentDao {

	public int registerComment(CommentBean CommentBean ) {
		int id_comment = -1;

		int id_post = CommentBean.getPost();
		int id_user= CommentBean.getId_user().getId_user();
		String comment = CommentBean.getComment();
		
		PreparedStatement preparedStatement = null;
		// we close the connection with the data base in the LISTENER
		try {
			Connection con = DBConnection.getConexion();
			String query = "insert into t_comment(idt_post,idt_users,comment) values (?,?,?)";
			
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setInt(1, id_post);
			preparedStatement.setInt(2, id_user);
			preparedStatement.setString(3, comment);

			int i = preparedStatement.executeUpdate();

			if (i != 0) {// all ok in the database
				id_comment=1;
				}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_user; // On failure, send a
						// message from here.
	}


	public List<CommentBean> listAllComment(int id_post) {

		List<CommentBean> CommentBean = new ArrayList();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConexion();
			
		String query = "select t_comment.idt_post ,"
				+ "t_comment.idt_users,"
				+ "t_comment.comment,"
				+ "t_comment.date,"
				+ "t_users.username "
				+" from t_comment , t_users where"
				+" t_comment.idt_users = t_users.idt_users and "
				+" t_comment.idt_post = ? "
				+" order by idt_comment  desc";
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setInt(1, id_post);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CommentBean pb= new CommentBean();
				pb.setPost(rs.getInt("idt_post"));
				
				pb.setComment(rs.getString("comment"));
				
				RegisterBean us= new RegisterBean();
				
				us.setId_user(rs.getInt("idt_users"));
				us.setUserName(rs.getString("username"));
				
				pb.setDate_comment(rs.getDate("date"));
			
				pb.setId_user(us);

				CommentBean.add(pb);

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CommentBean;
	}

}


