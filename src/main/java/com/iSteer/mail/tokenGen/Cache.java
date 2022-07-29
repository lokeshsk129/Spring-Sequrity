package com.iSteer.mail.tokenGen;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	
	
	//to store useEmail and OTP
	public static Map<String,Integer> otpMap = new HashMap<String,Integer>();
	
	//store OTP and Time
	public static Map<Integer,String> otpSessionMap = new HashMap<Integer,String>();
	
	//store access token and email
	public static Map<String,String> sessionInfo = new HashMap<String,String>();

//	public static Object otpSessionMap;
	
	
}
