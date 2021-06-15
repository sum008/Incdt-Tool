package com.incident.tool.model;

import org.springframework.stereotype.Component;

@Component
public class IncidentModel extends IncidentInfo{
	
	private String empId;
	private String empName;
	private String title; 	
	private String description;
	private String assignedTo;
	private String severity;
	private String incidentNumber;
	private String dateCreated;
	private String dateClosed;
	private String closingNotes;
	
	public IncidentModel() {
		/* will be required by spring to create its instance with zero parameter */
	}
	

	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getIncidentNumber() {
		return incidentNumber;
	}


	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getDateClosed() {
		return dateClosed;
	}


	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}


	public String getClosingNotes() {
		return closingNotes;
	}


	public void setClosingNotes(String closingNotes) {
		this.closingNotes = closingNotes;
	}


	@Override
	public String toString() {
		return String.format(
				"IncidentModel [empId=%s, empName=%s, title=%s, description=%s, assignedTo=%s, severity=%s, incidentNumber=%s, dateCreated=%s, dateClosed=%s, closingNotes=%s]",
				empId, empName, title, description, assignedTo, severity, incidentNumber, dateCreated, dateClosed,
				closingNotes);
	}
}
