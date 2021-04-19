package com.Incident_tool.utilityClasses;

import com.Incident_tool.model.IncidentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStringToObjectConvertor {
	
	public static IncidentModel convertToObject(String json) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(json, IncidentModel.class);
	}
}