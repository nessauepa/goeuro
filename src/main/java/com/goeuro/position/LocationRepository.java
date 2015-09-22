package com.goeuro.position;

import java.util.Arrays;
import java.util.List;

import com.goeuro.position.domain.Location;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class LocationRepository {

	private static final String LOCATION_ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/{city}";
	
	public List<Location> findAll(String city) {
		
		try {
			
			HttpResponse<Location[]> asObject = Unirest
													.get(LOCATION_ENDPOINT)
													.routeParam("city", city)
													.asObject(Location[].class);
			
			return Arrays.asList(asObject.getBody());
			
		} catch (Exception e) {
			
			throw new RuntimeException("Failed to get locations for city = " + city, e);
		}
		
	}
	
}
