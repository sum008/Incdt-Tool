package com.incident.tool.incident.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incident.tool.database.repository.IncidentEntity;
import com.incident.tool.factory.IncidentFactoryMethodsImpl;
import com.incident.tool.model.IncidentModel;
import com.incident.tool.model.IncidentQueryModel;

@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RestController // this annotation combines @controller->marks class for serving http request and 
				//@responseBody->will tread the result of a method as a response 

//As this class has only one method whose result will be a http response, we can mark this class as RestController
@RequestMapping("/incident")
public class IncidentController {
	@Autowired
//	@Qualifier("jsonObjectConvertor") -> Used when there are multiple bean of same object/class eligible for autowiring, 
										//so to eliminate this problem we can name the component/service/controller/restcontroller etc
	IncidentFactoryMethodsImpl incidentFactory;
	
	@PostMapping(value = "/create",
				consumes = MediaType.TEXT_PLAIN_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncidentModel> createNewIncident(@RequestBody String encryptedJson) {
		IncidentModel incidentModel = incidentFactory.createIncident(encryptedJson);
		return new ResponseEntity<>(incidentModel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewSingle",
			consumes = MediaType.TEXT_PLAIN_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncidentModel> viewSingleIncident(@ModelAttribute("incidentNumber")  IncidentQueryModel model) {
		IncidentModel incidentModel = incidentFactory.viewSingleIncident(model.getIncidentNumber());
		return new ResponseEntity<>(incidentModel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IncidentEntity>> viewIncidentList(@ModelAttribute("empId") IncidentQueryModel model) {
		List<IncidentEntity> incidentList = null;
		incidentList = incidentFactory.viewIncidentList(model.getEmpId());
		return new ResponseEntity<>(incidentList, HttpStatus.OK);
	}
}