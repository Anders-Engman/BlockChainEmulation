package com.model;

import java.security.MessageDigest;
 
public class HashGenerator {

	public static String generateHash(String input) 
	{ 
		try { 
			MessageDigest sha = MessageDigest.getInstance("SHA-256"); 
			int i = 0; 

			byte[] hash = sha.digest(input.getBytes("UTF-8")); 

			// hexHash will contain 
			// the Hexadecimal hash 
			StringBuffer hexHash = new StringBuffer(); 

			while (i < hash.length) { 
				String hex = Integer.toHexString(0xff & hash[i]); 
				if (hex.length() == 1) 
					hexHash.append('0'); //that zero could be a variable imported in from somewhere.
				hexHash.append(hex); 
				i++; 
			} 

			return hexHash.toString(); 
		} 
		catch (Exception e) { 
			throw new RuntimeException(e); 
		} 
	} 
}
