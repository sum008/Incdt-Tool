package com.incident.management.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.incident.management.incident.constants.DatabaseConstants;

public class DatabaseConnector {

	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DatabaseConstants.JDBC_URL, DatabaseConstants.USERNAME, DatabaseConstants.PASSWORD);
		} catch (SQLException e) {
			System.out.println("exception "+e.toString());
		}
		return connection;
	}
}
