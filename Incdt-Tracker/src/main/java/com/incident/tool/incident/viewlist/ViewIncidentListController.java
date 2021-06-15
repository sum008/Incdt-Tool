//package com.incident.tool.incident.viewlist;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.incident.tool.database.operations.CrudeOperations;
//import com.incident.tool.incident_model.IncidentQueryModel;
//import com.incident.tool.incident_model.IncidentModel;
//
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@RestController
//@RequestMapping("/incident")
//public class ViewIncidentListController {
//
//	@Autowired
//	CrudeOperations crudeOperations;
//	
//	@GetMapping(value = "/viewList",
//			produces = MediaType.APPLICATION_JSON_VALUE)
//public List<IncidentModel> viewIncidentList(@ModelAttribute("empId")  IncidentQueryModel model) {
//		
//		List<IncidentModel> incidentList = null;
//	try {
//		incidentList = crudeOperations.getIncidentList(model.getEmpId());
//	} catch (NoSuchElementException e) {
//		e.printStackTrace();
//	}
//	return incidentList;
//}
//}
