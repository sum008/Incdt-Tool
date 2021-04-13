package com.incident.management.database.manageIncident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.incident.managament.utilityClasses.DateUtility;
import com.incident.managament.utilityClasses.IncidentNumberGenerator;
import com.incident.management.database.connection.DatabaseConnector;
import com.incident.management.incident.constants.DatabaseConstants;
import com.incident.management.incident.constants.IncidentConstants;
import com.incident.management.logging.LogClass;
import com.incident.management.model.IncidentModel;

public class SaveNewIncident {
	
	private static final String INSERT_NEW_INCIDENT = String.format("INSERT INTO %s VALUES (?, ?, ?, ?, ?, ?, ?);", DatabaseConstants.TABLE_NAME);
	
	public IncidentModel saveIncident(IncidentModel incientModel) throws ClassNotFoundException, SQLException {
		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String incidentNumber = null;
		IncidentModel model = new IncidentModel();
		try {
			ps = connection.prepareStatement(INSERT_NEW_INCIDENT);
		} catch (SQLException e) {
			LogClass.logging(SaveNewIncident.class).error("Error occured while inserting to database", e);
		}
		try {
			incidentNumber = new IncidentNumberGenerator().generateTicketNumber();
			ps.setString(1, incidentNumber);
			ps.setString(2, incientModel.getEmpId());
			ps.setString(3, incientModel.getEmpName());
			ps.setString(4, incientModel.getTitle());
			ps.setString(5, incientModel.getDescription());
			ps.setString(6, DateUtility.getCurrentDate(IncidentConstants.DATE_FORMAT));
			ps.setInt(7, incientModel.getSeverity());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			LogClass.logging(SaveNewIncident.class).error("Error occured while inserting to database", e);
		}
		
		if (result == 1) {
			model = new RetrieveSingleIncident().retrieveIncident(incidentNumber);
		} else {
			model.setExceptionMessage("Unable to create incident at this time. Please try again later.");
		}
		return model;
	}

}
