package com.ert.testgeo;

import com.maxmind.geoip.LookupService;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoIPv4 {

	private static LookupService lookUp;

	static {
		try {
			File file = new File("F://GeoLiteCity.dat");
			lookUp = new LookupService(file,
					LookupService.GEOIP_MEMORY_CACHE);

			//System.out.println("GeoIP Database loaded: " + lookUp.getDatabaseInfo());
		} catch (IOException e) {
			System.out.println("Could not load geo ip database: " + e.getMessage());
		}
	}

	public static GeoLocation getLocation(String ipAddress) {
		return GeoLocation.map(lookUp.getLocation(ipAddress));
	}

	public static GeoLocation getLocation(long ipAddress) {
		return GeoLocation.map(lookUp.getLocation(ipAddress));
	}

	public static GeoLocation getLocation(InetAddress ipAddress) {
		return GeoLocation.map(lookUp.getLocation(ipAddress));
	}
}