package com.incident.managament.utilityClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.incident.management.database.connection.DatabaseConnector;
import com.incident.management.incident.constants.DatabaseConstants;

public class RetrieveIncidentUtility {
	
	private static final String RETRIEVE_SINGLE_INCIDENT = "SELECT * FROM %1$s WHERE %2$s = ?;";

	public ResultSet getIncident (String columnName, String findBy) throws ClassNotFoundException {
		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		String query = String.format(RETRIEVE_SINGLE_INCIDENT, DatabaseConstants.TABLE_NAME, columnName);
		try {
			System.out.println(query);
			ps = connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Error occured while inserting to database "+e.toString());
		}
		try {
			ps.setString(1, findBy);
			result = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error occured retrieving the incident "+e.toString());
		}
		return result;
	}
}
