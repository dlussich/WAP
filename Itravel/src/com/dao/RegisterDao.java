package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.RegisterBean;
import com.util.DBConnection;

public class RegisterDao {

	public int registerUser(RegisterBean registerBean) {
		int id_user = -1;

		String fullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();
		String gender = registerBean.getGender();
		String state = registerBean.getState();
		String city = registerBean.getCity();
		String street = registerBean.getStreet();
		String zipCode = registerBean.getZipCode();
		String birthYear = registerBean.getBirthYear();

		PreparedStatement preparedStatement = null;

		// we close the connection with the data base in the LISTENER
		try {
			Connection con = DBConnection.getConexion();
			String query = "insert into t_users(idt_users,fullname,email,username,password,Gender,State,City,Street,Zip_Code,Birth_Year) values (NULL,?,?,?,?,?,?,?,?,?,?)"; // Insert
			// user
			// details
			// into
			// the
			// table
			// 'USERS'
			preparedStatement = con.prepareStatement(query); // Making use of
																// prepared
																// statements
																// here to
																// insert bunch
																// of data
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, gender);
			preparedStatement.setString(6, state);
			preparedStatement.setString(7, city);
			preparedStatement.setString(8, street);
			preparedStatement.setString(9, zipCode);
			preparedStatement.setString(10, birthYear);

			int i = preparedStatement.executeUpdate();

			if (i != 0) {// Just to ensure data has been inserted into the
							// database
				// to know the ID for the new user
				query = "select idt_users  from t_users where username=?";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, userName);// the username is
															// unique
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					id_user = rs.getInt("idt_users");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_user; // On failure, send a
						// message from here.
	}
	
	public int updateUser(RegisterBean registerBean) {
		
		int res = -1;
		int id_user = registerBean.getId_user();

		String fullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String password = registerBean.getPassword();
		String gender = registerBean.getGender();
		String state = registerBean.getState();
		String city = registerBean.getCity();
		String street = registerBean.getStreet();
		String zipCode = registerBean.getZipCode();
		String birthYear = registerBean.getBirthYear();

		PreparedStatement preparedStatement = null;

		// we close the connection with the data base in the LISTENER
		try {
			Connection con = DBConnection.getConexion();
			String query = "update t_users set fullname=?, email=?, password=? ,Gender=? ,State=?, City=?, Street=?, Zip_Code=?, Birth_Year=? where idt_users=?" ; // 
			// user
			// details
			// into
			// the
			// table
			// 'USERS'
			preparedStatement = con.prepareStatement(query); // Making use of
																// prepared
																// statements
																// here to
																// insert bunch
																// of data
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, state);
			preparedStatement.setString(6, city);
			preparedStatement.setString(7, street);
			preparedStatement.setString(8, zipCode);
			preparedStatement.setString(9, birthYear);
			preparedStatement.setInt(10, id_user);

			res = preparedStatement.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res; // On failure, send a
						// message from here.
	}

	public RegisterBean CheckUser(String username) {
		RegisterBean RegisterBean_DB= new RegisterBean();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.getConexion();
			String query = "select idt_users,fullname, email,Gender, State, City, Street, Zip_Code,Birth_Year, password from t_users where username=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				RegisterBean_DB.setUserName(username);
				RegisterBean_DB.setId_user(rs.getInt("idt_users"));
				RegisterBean_DB.setFullName(rs.getString("fullname"));
				RegisterBean_DB.setGender(rs.getString("Gender"));
				RegisterBean_DB.setState(rs.getString("State"));
				RegisterBean_DB.setCity(rs.getString("City"));
				RegisterBean_DB.setStreet(rs.getString("Street"));
				RegisterBean_DB.setZipCode(rs.getString("Zip_Code"));
				RegisterBean_DB.setBirthYear(rs.getString("Birth_Year"));
				RegisterBean_DB.setEmail(rs.getString("email"));
				RegisterBean_DB.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RegisterBean_DB; // On failure, send null
	}

}
