package com.incident.management.register.resources;

import java.util.HashSet;
import java.util.Set;

import com.incident.managament.utilityClasses.EncryptJsonString;
import com.incident.management.incident.create.CreateIncidentClient;
import com.incident.management.incident.view.list.ViewIncidentListClient;
import com.incident.management.incident.view.single.ViewSingleIncidentClient;
import com.incident.management.logging.LogClass;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/*")
public class RegisterResources extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		LogClass.logging(RegisterResources.class).info("Resources registered successfully.");
	    final Set<Class<?>> classes = new HashSet<>();
	    // register root resource
	    classes.add(CreateIncidentClient.class);
	    classes.add(ViewSingleIncidentClient.class);
	    classes.add(ViewIncidentListClient.class);
	    classes.add(EncryptJsonString.class);
	    return classes;
	}

}
