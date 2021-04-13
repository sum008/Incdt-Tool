package com.incident.management.database.manageIncident;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.incident.managament.utilityClasses.RetrieveIncidentUtility;
import com.incident.management.model.IncidentModel;

public class RetrieveSingleIncident {
	
	public IncidentModel retrieveIncident(String incidentNumber) throws SQLException, ClassNotFoundException {
		ResultSet result = new RetrieveIncidentUtility().getIncident("incidentNumber", incidentNumber);
		IncidentModel model = new IncidentModel();
		if (result != null) {
			while (result.next()) {
				model.setIncidentNumber(result.getString("incidentNumber"));
				model.setEmpId(result.getString("EmpId"));
				model.setEmpName(result.getString("EmpName"));
				model.setTitle(result.getString("title"));
				model.setDescription(result.getString("description"));
				model.setDateCreated(result.getString("dateCreated"));
				model.setSeverity(result.getInt("severity"));
			}
		} 
		return model;
	}

}
