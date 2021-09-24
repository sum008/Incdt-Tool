package com.incident.tool.database.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incident_record1")
public class IncidentEntity {

	@Column(name = "empid", nullable = false)
	private String empId;
	@Column(name = "empname", nullable = false)
	private String empName;
	@Column(name = "title", nullable = false)
	private String title; 
	@Column(name = "description")
	private String description;
	@Column(name = "assignedTo")
	private String assignedTo;
	@Column(name = "severity", nullable = false)
	private String severity;
	
	@Id
	@Column(name = "incidentNumber", nullable = false)
	private String incidentNumber;
	@Column(name = "dateCreated", nullable = false)
	private String dateCreated;
	@Column(name = "dateClosed")
	private String dateClosed;
	@Column(name = "closingNotes")
	private String closingNotes;
	
	public IncidentEntity() {
		/* will be required by spring to create its instance */
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
}
