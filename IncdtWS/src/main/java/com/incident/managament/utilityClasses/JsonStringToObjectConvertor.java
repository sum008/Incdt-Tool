package com.incident.managament.utilityClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incident.management.model.IncidentModel;

public class JsonStringToObjectConvertor {
	
	public static IncidentModel convertToObject(String json) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(json, IncidentModel.class);
	}
}