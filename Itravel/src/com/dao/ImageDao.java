package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.ImageBean;
import java.sql.Blob;
import com.util.DBConnection;
import sun.misc.BASE64Encoder;

public class ImageDao {

	public int registerImage(ImageBean ImageBean) {

		int id_image=-1;
		int post = ImageBean.getPost();
		InputStream image = ImageBean.getImage();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConexion();
			String query = "insert into t_image(idt_post,image) values(?,?)"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_IMAGE

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data

			preparedStatement.setInt(1, post);
			preparedStatement.setBlob(2, image);

			int i = preparedStatement.executeUpdate();

			if (i != 0){
				 query = "select MAX(idt_image)  as idt_image  from t_image where idt_post=?";
				 preparedStatement = con.prepareStatement(query);
				 preparedStatement.setInt(1, post);
				 ResultSet rs = preparedStatement.executeQuery();
					if (rs.next()) {
						id_image= rs.getInt("idt_image");
					}
				
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_image; // On failure, send a -1
	}

	public ImageBean GetImage(int id) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ImageBean ImageBean = new ImageBean();
		try {
			con = DBConnection.getConexion();
			String query = "select * from t_image where idt_post=?"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'T_IMAGE

			preparedStatement = con.prepareStatement(query); // Making use of
			// prepared
			// statements
			// here to
			// insert bunch
			// of data
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				ImageBean.setId_image(rs.getInt("idt_image"));
				ImageBean.setPost(id);
				Blob blob = rs.getBlob("image");
				byte byteArray[] = blob.getBytes(1, (int) blob.length());
				BASE64Encoder base64Encoder = new BASE64Encoder();
				StringBuilder  imageString = new StringBuilder();
		        imageString.append("data:image/png;base64,");
		        imageString.append(base64Encoder.encode(byteArray));
				ImageBean.setImageString(imageString.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ImageBean;

	}

}
