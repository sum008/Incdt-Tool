package com.incident.tool.database.repository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incident.tool.constants.IncidentConstants;
import com.incident.tool.model.IncidentModel;
import com.incident.tool.utiliy.DateUtility;
import com.incident.tool.utiliy.IncidentNumberGenerator;

@Service
public class IncidentRepositoryServiceImpl implements IncidentRepositoryService {
	
	@Autowired
	IncidentNumberGenerator incidentGenerator;
	
	@Autowired
	DateUtility date;
	
	@Autowired
	IncidentRepository repository;
	
	public void saveIncident(IncidentModel incidentModel) throws NoSuchAlgorithmException {
		IncidentEntity incidentEntity = this.buildRequest(incidentModel);
		repository.save(incidentEntity);
	}
	
	public IncidentEntity getIncident(String incidentNumber) {
		return repository.findById(incidentNumber)
									.orElseThrow();
	}
	
	public List<IncidentEntity> getIncidentList(String empId) {
		return repository.getAllIncidents(empId);
	}
	
	private IncidentEntity buildRequest(IncidentModel incidentModel) throws NoSuchAlgorithmException {
		incidentModel.setDateCreated(date.getCurrentDate(IncidentConstants.DATE_FORMAT));
		incidentModel.setIncidentNumber(incidentGenerator.generateTicketNumber());
		
		IncidentEntity incidentEntity = new IncidentEntity();
		incidentEntity.setIncidentNumber(incidentModel.getIncidentNumber());
		incidentEntity.setDateCreated(incidentModel.getDateCreated());
		incidentEntity.setEmpName(incidentModel.getEmpName());
		incidentEntity.setEmpId(incidentModel.getEmpId());
		incidentEntity.setTitle(incidentModel.getTitle());
		incidentEntity.setDescription(incidentModel.getDescription());
		incidentEntity.setSeverity(incidentModel.getSeverity());
		return incidentEntity;
	}
}