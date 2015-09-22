package com.goeuro;

import org.apache.commons.lang3.StringUtils;

import com.goeuro.position.LocationManager;

public class App 
{
	LocationManager manager = new LocationManager();
	
    public static void main(String[] args) {
    	
    	String response = new App().execute(args);
		System.out.println(response);
    }
    
    public App() {
    	new AppInitializer().initialize();
    }
    
	String execute(String[] args) {
		
		if (args == null || args.length != 1 || StringUtils.isEmpty(args[0])) {
    		return "Usage: java -jar GoEuroTest.java <city>";
    	}

		try {
			
			String fileName = manager.searchAndGenerateFile(args[0]);
			return "File generated: " + fileName;
			
		} catch (Exception e) {
			return "Unexpected fail: " + e.getMessage();
		}
	}
}
