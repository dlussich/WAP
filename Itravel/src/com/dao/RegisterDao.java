package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.RegisterBean;
import com.util.DBConnection;

public class RegisterDao {
	
	public String registerUser(RegisterBean registerBean) {
		

		
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

		// initialize connection in DB connection, otherwise it'll be null
		DBConnection connection = new DBConnection("itravel");
		PreparedStatement preparedStatement = null;

		// modify to try-with-resources, so we don't need close connection
		try (Connection con = DBConnection.getConexion()){
			
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

			if (i != 0) // Just to ensure data has been inserted into the
						// database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a
														// message from here.
	}
}
