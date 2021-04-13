package com.incident.managament.utilityClasses;

import com.incident.management.incident.constants.DatabaseConstants;

public class IncidentNumberGenerator {
	
	public String generateTicketNumber() {
		
		String baseDate = DateUtility.getCurrentDate(DatabaseConstants.BASE_INCIDENT_NO_FORMAT);
		int seedMilliSeconds = Integer.parseInt(DateUtility.getCurrentDate(DatabaseConstants.BASE_SEED_MILLISECONDS));
		int seedSeconds = Integer.parseInt(DateUtility.getCurrentDate(DatabaseConstants.BASE_SEED_SECONDS));
		int randomSeedValue = (int) (Math.random()*100);
		int newSeed = seedMilliSeconds + randomSeedValue + seedSeconds;
		return new StringBuilder().append("INC").append(baseDate).append(String.valueOf(newSeed)).toString();	
	}
}
