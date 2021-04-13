package com.incident.management.database.manageIncident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.incident.managament.utilityClasses.RetrieveIncidentUtility;
import com.incident.management.model.IncidentModel;

public class RetrieveIncidentList {

	public List<IncidentModel> retrieveIncidentList(String empId) throws SQLException, ClassNotFoundException {
		ResultSet result = new RetrieveIncidentUtility().getIncident("empId", empId);
		List<IncidentModel> IncidentModelList = new ArrayList<IncidentModel>();
		IncidentModel model = null;
		if (result != null) {
			while (result.next()) {
				model = new IncidentModel();
				model.setIncidentNumber(result.getString("incidentNumber"));
				model.setEmpId(result.getString("EmpId"));
				model.setEmpName(result.getString("EmpName"));
				model.setTitle(result.getString("title"));
				model.setDescription(result.getString("description"));
				model.setDateCreated(result.getString("dateCreated"));
				model.setSeverity(result.getInt("severity"));
				IncidentModelList.add(model);
			}
		} 
		return IncidentModelList;
	}
}
