package com.ert.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String userName = "root";
		String password = "12345";
		String connectionURL = "jdbc:mysql://localhost:3306/ERT?autoReconnect=true&useSSL=false";
		return getMySQLConnection(connectionURL, userName, password);
	}

	private static Connection getMySQLConnection(String connectionURL, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
