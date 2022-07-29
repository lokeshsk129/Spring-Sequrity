package com.iSteer.mail.tokenGen;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenGenerator {

	public static String MD5(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		
		byte[] messageDigest = md.digest(input.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);

		String hashtext = number.toString();
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		System.out.println(hashtext.length());
		return "" + hashtext;
	}
}
