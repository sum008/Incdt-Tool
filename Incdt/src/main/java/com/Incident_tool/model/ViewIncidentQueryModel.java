package com.Incident_tool.model;

import jakarta.ws.rs.QueryParam;

public class ViewIncidentQueryModel {

	private @QueryParam("empId") String empId;
	private  @QueryParam("incidentNumber") String incidentNumber;
		
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getIncidentNumber() {
		return incidentNumber;
	}
	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}
}
