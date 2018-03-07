package com.ert.testgeo;

import java.net.UnknownHostException;

public class LookUpProgram {

	public static GeoLocation getIpLocation(String IP) throws UnknownHostException {
		return GeoIPv4.getLocation(IP);
	}

}
