package com.accolite.rest.RestProject.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static MyConnection instance;
	private static java.sql.Connection connection;
	
	private MyConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/accobook","root","root");  
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			synchronized (MyConnection.class) {
				if(instance == null) {
					instance = new MyConnection();
				}
			}
		}
		return instance.connection;
	}
}

