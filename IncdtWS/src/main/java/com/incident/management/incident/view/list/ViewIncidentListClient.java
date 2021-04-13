package com.incident.management.incident.view.list;

import java.sql.SQLException;
import java.util.List;

import com.incident.management.database.manageIncident.RetrieveIncidentList;
import com.incident.management.incident.constants.IncidentConstants;
import com.incident.management.logging.LogClass;
import com.incident.management.model.IncidentModel;
import com.incident.management.model.ViewIncidentQueryModel;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(IncidentConstants.INCIDENT_PATH)
public class ViewIncidentListClient {
	
	
	@Path(IncidentConstants.VIEWLIST_INCIDENT_PATH)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IncidentModel> viewIncidentList(@BeanParam ViewIncidentQueryModel viewIncidentQueryModel) {
		List<IncidentModel> model = null;
		try {
			model = new RetrieveIncidentList().retrieveIncidentList(viewIncidentQueryModel.getEmpId());
			LogClass.logging(ViewIncidentListClient.class).info("Incidents retrieved successfully.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
