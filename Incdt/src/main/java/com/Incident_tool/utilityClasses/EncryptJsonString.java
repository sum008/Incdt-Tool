package com.Incident_tool.utilityClasses;

import com.Incident_tool.encrypt_decrypt.utility.EncDec;
import com.Incident_tool.incident.constants.IncidentConstants;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path(IncidentConstants.INCIDENT_PATH)
public class EncryptJsonString {
	
	@Path("/encrypt")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public String encryptJson(String json) throws Exception {
		EncDec enc = new EncDec();
		return enc.encrypt(json);
	}

}
