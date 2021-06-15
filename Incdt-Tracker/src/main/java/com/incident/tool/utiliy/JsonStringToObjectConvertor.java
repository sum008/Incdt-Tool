package com.incident.tool.utiliy;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incident.tool.model.IncidentModel;

@Service // or @Service("some name to denote this particular service uniquely")
public class JsonStringToObjectConvertor {
	
	public IncidentModel convertToObject(String json) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(json, IncidentModel.class);
	}
}