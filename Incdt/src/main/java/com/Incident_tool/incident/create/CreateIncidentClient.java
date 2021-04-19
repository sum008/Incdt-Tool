package com.Incident_tool.incident.create;

import java.sql.SQLException;

import com.Incident_tool.database.manageIncident.SaveNewIncident;
import com.Incident_tool.incident.constants.IncidentConstants;
import com.Incident_tool.logging.LogClass;
import com.Incident_tool.model.IncidentModel;
import com.Incident_tool.utilityClasses.DecryptPayload;
import com.Incident_tool.utilityClasses.JsonStringToObjectConvertor;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(IncidentConstants.INCIDENT_PATH)
public class CreateIncidentClient {
	
	@Path(IncidentConstants.CREATE_INCIDENT_PATH)
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public IncidentModel testEncryption(String encryptedJson) throws Exception {
		IncidentModel model = null;
		IncidentModel incidentModel = JsonStringToObjectConvertor.convertToObject(DecryptPayload.decryptPayload(encryptedJson));
		try {
			model = new SaveNewIncident().saveIncident(incidentModel);
			LogClass.logging(CreateIncidentClient.class).info("Incident created successfully.");
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
