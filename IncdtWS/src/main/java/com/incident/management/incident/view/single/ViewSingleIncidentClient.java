package com.incident.management.incident.view.single;

import java.sql.SQLException;

import com.incident.management.database.manageIncident.RetrieveSingleIncident;
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
public class ViewSingleIncidentClient {
	@Path(IncidentConstants.VIEW_INCIDENT_PATH)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public IncidentModel viewIncident(@BeanParam ViewIncidentQueryModel viewIncidentQueryModel) {
		IncidentModel model = null;
		try {
			model = new RetrieveSingleIncident().retrieveIncident(viewIncidentQueryModel.getIncidentNumber());
			LogClass.logging(ViewSingleIncidentClient.class).info("Incident retrieved successfully.");
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
