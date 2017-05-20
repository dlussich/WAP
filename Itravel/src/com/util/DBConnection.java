package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	final private String machine = "localhost";
	final private int port = 3306;
	final private String user = "mum";
	final private String password = "mum";

	private String server = "";
	private static Connection Connection = null;

	// CONSTRUCTOR
	// parameter is the name of the database
	public DBConnection(String database){
        this.server="jdbc:mysql://"+this.machine+":"+
                        this.port+"/"+database;
 
        //register the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("error in the registrer of the driver");
            System.out.println(e);
            System.exit(0); //stop the execution
        }
 
        //make the connection with the data base
        try {

        	Connection = DriverManager.getConnection(this.server +  "?" + "user=" + user + "&password=" + password
            		 + "&useSSL=false" 
            		 + "&requireSSL=false" );
            
   
		            
        } catch (SQLException e) {
            System.err.println("error connecting the data base");
            System.out.println(e);
            System.exit(0); //stop the execution
        }
        System.out.println("connecting with "+database);
    }

	// return the object of the connection with
	// the database for the controller class.
	public static Connection getConexion() {
		return Connection;
	}

}
