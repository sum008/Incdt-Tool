package com.incident.tool.factory;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.incident.tool.constants.IncidentConstants;
import com.incident.tool.database.repository.IncidentEntity;
import com.incident.tool.database.repository.IncidentRepositoryServiceImpl;
import com.incident.tool.model.IncidentModel;
import com.incident.tool.security.utility.EncDec;
import com.incident.tool.utiliy.JsonStringToObjectConvertor;

@Service
public class IncidentFactoryMethodsImpl implements IncidentFactoryMethods<IncidentModel> {
	
	private JsonStringToObjectConvertor  jsonStringToObjectConvertor;
	private IncidentModel incidentModel;
	private EncDec decrypt;
	private IncidentRepositoryServiceImpl incidentRepoService;
	
	@Autowired
	public IncidentFactoryMethodsImpl(JsonStringToObjectConvertor jsonStringToObjectConvertor, EncDec decrypt,
			IncidentRepositoryServiceImpl incidentRepoService, IncidentModel incidentModel) {
		super();
		this.jsonStringToObjectConvertor = jsonStringToObjectConvertor;
		this.decrypt = decrypt;
		this.incidentRepoService = incidentRepoService;
		this.incidentModel = incidentModel;
	}

	public IncidentModel createIncident(String encryptedJson) {
		try {
			incidentModel = jsonStringToObjectConvertor.convertToObject(decrypt.decrypt(encryptedJson));
			incidentRepoService.saveIncident(incidentModel);
			this.buildResponse(incidentModel);
		} catch (JsonProcessingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			incidentModel.setExceptionMessage("Exception occured while parsing json data");
			incidentModel.setStatusCode(IncidentConstants.FAILED);
			incidentModel.setHttpStatusCode(HttpStatus.EXPECTATION_FAILED.toString());
		}
		return incidentModel;
	}

	public IncidentModel viewSingleIncident(String incidentNumber) {
		try {
			IncidentEntity incidentEntity = incidentRepoService.getIncident(incidentNumber);
			incidentModel = this.buildResponse(incidentEntity); 
		} catch (NoSuchElementException e) {
			incidentModel.setExceptionMessage(String.format("No incidentNumber %s exists in record",incidentNumber));
			e.printStackTrace();
		}
		return incidentModel;
	}
	
	public List<IncidentEntity> viewIncidentList(String empId) {
		List<IncidentEntity> incidentList = null;
		try {
			incidentList = incidentRepoService.getIncidentList(empId);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return incidentList;
	}
	
	private <T> IncidentModel buildResponse(T incidentModel) {
		IncidentModel model = null;
		if (incidentModel instanceof IncidentEntity) {
			model =  new IncidentModel();
			IncidentEntity entity = (IncidentEntity) incidentModel;
			model.setIncidentNumber(entity.getIncidentNumber());
			model.setDateCreated(entity.getDateCreated());
			model.setEmpName(entity.getEmpName());
			model.setEmpId(entity.getEmpId());
			model.setTitle(entity.getTitle());
			model.setDescription(entity.getDescription());
			model.setSeverity(entity.getSeverity());
			model.setStatusMessage("Incident retrieved successfully");
		} else {
			model = (IncidentModel) incidentModel;
			model.setStatusMessage("Incident created successfully");
		}
		model.setStatusCode(IncidentConstants.SUCCESS);
		model.setHttpStatusCode(HttpStatus.ACCEPTED.toString());
		return model;
	}
}
