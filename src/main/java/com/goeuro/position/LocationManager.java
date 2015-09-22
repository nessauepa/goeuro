package com.goeuro.position;

import java.io.IOException;
import java.util.List;

import com.goeuro.position.domain.Location;

public class LocationManager {

	LocationRepository repository = new LocationRepository();

	public String searchAndGenerateFile(String city) throws IOException {

		List<Location> locations = repository.findAll(city);

		return LocationCsvWriter.write(city, locations);
	}

	
}
