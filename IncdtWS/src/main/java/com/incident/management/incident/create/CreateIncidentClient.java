package com.incident.management.incident.create;

import java.sql.SQLException;

import com.incident.managament.utilityClasses.DecryptPayload;
import com.incident.managament.utilityClasses.JsonStringToObjectConvertor;
import com.incident.management.database.manageIncident.SaveNewIncident;
import com.incident.management.incident.constants.IncidentConstants;
import com.incident.management.logging.LogClass;
import com.incident.management.model.IncidentModel;

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
