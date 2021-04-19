package com.Incident_tool.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LogClass {

	public static Logger logging (Class<?> className) {
		BasicConfigurator.configure();
		return Logger.getLogger(className);
		
//		return new StringBuilder().append(className.getName())
//				.append(" ")
//				.append(logMessage).toString();

	}
}
