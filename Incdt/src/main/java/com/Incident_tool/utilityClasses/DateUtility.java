package com.Incident_tool.utilityClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	public static String getCurrentDate (String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

}
