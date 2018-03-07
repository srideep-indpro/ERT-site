package com.ert.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.ert.testgeo.GeoLocation;

public class SendSMS {
	public static String sendSMS(String phoneNumber, GeoLocation userLocation) {
		try {
			
			String messageBody = "I'm in danger in " +userLocation.getCountryName() + ", " //
			+userLocation.getCity() + " at "+userLocation.getLatitude() +", " +userLocation.getLongitude()//
			+" Please help me";
			
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("8/bD2CuUNEY-3eHkyCGds4yplBNrWtiQGvqNvJEA5F", "UTF-8");
			String message = "&message=" + URLEncoder.encode(messageBody, "UTF-8");
			String sender = "&sender=" + "";
			String numbers = "&numbers=" + URLEncoder.encode(phoneNumber, "UTF-8");

			// Send data
			String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult = "";
			while ((line = rd.readLine()) != null) {
				// Process line...
				sResult = sResult + line + " ";
			}
			rd.close();

			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}
}
