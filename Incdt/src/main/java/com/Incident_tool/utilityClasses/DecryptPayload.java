package com.Incident_tool.utilityClasses;

import com.Incident_tool.encrypt_decrypt.utility.EncDec;

public class DecryptPayload {
	
	public static String decryptPayload(String encryptedPayload) throws Exception {
		EncDec dec = new EncDec();
		return dec.decrypt(encryptedPayload);
	}

}
