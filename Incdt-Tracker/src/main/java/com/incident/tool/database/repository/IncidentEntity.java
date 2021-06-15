package com.incident.tool.database.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incident_record")
public class IncidentEntity {

	private String empId;
	private String empName;
	private String title; 	
	private String description;
	private String assignedTo;
	private String severity;
	
	@Id
	private String incidentNumber;
	private String dateCreated;
	private String dateClosed;
	private String closingNotes;
	
	public IncidentEntity() {
		/* will be required by spring to create its instance with zero parameter */
	}
	
	@Column(name = "empid", nullable = false)
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	@Column(name = "empname", nullable = false)
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "assignedTo")
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	@Column(name = "severity", nullable = false)
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	@Column(name = "incidentNumber", nullable = false)
	public String getIncidentNumber() {
		return incidentNumber;
	}
	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}
	
	@Column(name = "dateCreated", nullable = false)
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Column(name = "dateClosed")
	public String getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}
	
	@Column(name = "closingNotes")
	public String getClosingNotes() {
		return closingNotes;
	}
	public void setClosingNotes(String closingNotes) {
		this.closingNotes = closingNotes;
	}
}
