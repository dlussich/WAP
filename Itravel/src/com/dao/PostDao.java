package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.bean.ImageBean;
import com.bean.PostBean;
import com.util.DBConnection;

public class PostDao {

	public int registerPost(PostBean PostBean) {

		int id_post=-1;
		//int id_post = PostBean.getPost();
		String text_post	=PostBean.getText();
		int id_user=PostBean.getUser();
		String state	=PostBean.getState();
		String city	=PostBean.getCity();
		int zip_code	=PostBean.getZip_code();
		

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConexion();
			//String query = "insert into t_post(idt_post,text,idt_users) values(?,?,?)"; // Insert
			String query = "insert into t_post(text,idt_users, state, city, zip_code) values(?,?,?,?,?)"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_POST

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data

			//preparedStatement.setInt(1, id_post);
			preparedStatement.setString(1, text_post);
			preparedStatement.setInt(2, id_user);
			preparedStatement.setString(3, state);
			preparedStatement.setString(4, city);
			preparedStatement.setInt(5, zip_code);
			
			int i = preparedStatement.executeUpdate();

			if (i != 0) {// Just to ensure data has been inserted into the
						// database			
				 query = "select MAX(idt_post)  as idt_post  from t_post where idt_users=?";
				 preparedStatement = con.prepareStatement(query);
				 preparedStatement.setInt(1, id_user);
				 ResultSet rs = preparedStatement.executeQuery();
					if (rs.next()) {
						id_post= rs.getInt("idt_post");
					}

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_post; // On failure, send -1
}
	
	
	

	public List<PostBean> listAllPost() {

		List<PostBean> PostBean = new ArrayList();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConexion();
			
	//		String sql="select id, category_id, product_code, product_name, uom from tbl_product order by id";
	//		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ProductMapper());
	//		return list;
				
			String query = "select idt_post,"
					+ "text,"
					+ "idt_users,"
					+ "date, "
					+ "state, "
					+ "city, "
					+ "zip_code ,"
					+ "likes from t_post order by idt_post   desc"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_POST

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PostBean pb= new PostBean();
				pb.setPost(rs.getInt("idt_post"));
				pb.setText(rs.getString("text"));
				pb.setUser(rs.getInt("idt_users"));
				pb.setDate_post(rs.getDate("date"));
				pb.setLikes(rs.getInt("likes"));
				pb.setState(rs.getString("state"));
				pb.setCity(rs.getString("city"));
				pb.setZip_code(rs.getInt("zip_code"));
				
				
				// AGREGADO DESPUES DE DIEGO
				ImageDao ImageDao = new ImageDao();
				ImageBean ImageBean =ImageDao.GetImage(rs.getInt("idt_post"));
				pb.setImage(ImageBean.getImageString());
				
				// AGREGADO DESPUES DE DIEGO
				PostBean.add(pb);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PostBean;

	}
	
	
	public int Selectlikes(PostBean PostBean) {

		int like=-1;
		int id_post = PostBean.getPost();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.getConexion();
			String query = "select likes from t_post where idt_post=?"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_POST

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data

			//preparedStatement.setInt(1, id_post);
			preparedStatement.setInt(1, id_post);
			
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {// Just to ensure data has been inserted into the
						// database			
				like= rs.getInt("likes");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return like; // On failure, send -1
}
	

	public int Updatelikes(PostBean PostBean) {
		int res=-1;
		int id_post=PostBean.getPost();
		int likes=PostBean.getLikes();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.getConexion();
			String query = "UPDATE t_post SET likes = ? where idt_post= ?"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_POST

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data

			//preparedStatement.setInt(1, id_post);
			preparedStatement.setInt(1, likes );
			preparedStatement.setInt(2, id_post);
			
			//System.out.println(preparedStatement);
			
			int i = preparedStatement.executeUpdate();
			//System.out.println("Resulset "+ i);
			
			if (i != 0) {// Just to ensure data has been inserted into the
						// database			
				res=i;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res; // On failure, send -1
}
	
	}
