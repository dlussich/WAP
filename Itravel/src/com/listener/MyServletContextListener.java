package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.PostDao;
import com.util.DBConnection;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	 // Don't forget to close your database connection when the 
        // application is shutting down.  Put that code here!
    	Connection con = null;
    	con = DBConnection.getConexion();
    	System.out.println("Close Conection with database");
    	
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	 // This is where you would put your code to initialize the
        // database connection.  You could then set it as an attribute.
        // Now the entire application will have access to it.    	
    	new DBConnection("itravel");
    }
	
}
