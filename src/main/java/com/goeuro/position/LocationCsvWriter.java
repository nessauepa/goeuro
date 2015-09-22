package com.goeuro.position;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.goeuro.position.domain.Location;

public class LocationCsvWriter {

	private static final char DELIMITER = ',';
	private static final String EXTENSION = ".csv";

	public static String write(String name, List<Location> locations) throws IOException {

		String fileName = name + EXTENSION;
		
		CSVWriter writer = new CSVWriter(new FileWriter(fileName), DELIMITER);

		for (Location l : locations) {
			
			String[] entries = new String[] { 
					l.getId().toString(), 
					l.getName().toString(),
					l.getType().toString(), 
					l.getGeoPosition().getLatitude().toString(),
					l.getGeoPosition().getLongitude().toString() };
			
			writer.writeNext(entries);
		}
		writer.close();
		
		return fileName;
	}
}