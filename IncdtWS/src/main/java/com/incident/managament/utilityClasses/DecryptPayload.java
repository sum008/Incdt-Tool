package com.incident.managament.utilityClasses;

import com.incident.management.encrypt_decrypt.utility.EncDec;

public class DecryptPayload {
	
	public static String decryptPayload(String encryptedPayload) throws Exception {
		EncDec dec = new EncDec();
		return dec.decrypt(encryptedPayload);
	}

}
