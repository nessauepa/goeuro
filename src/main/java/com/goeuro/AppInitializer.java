package com.goeuro;

import java.io.IOException;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class AppInitializer {

	public void initialize() {
		initializeUnirest();
	}

	private void initializeUnirest() {
		
		Unirest.setObjectMapper(new ObjectMapper() {
			private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return jacksonObjectMapper.readValue(value, valueType);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}

			public String writeValue(Object value) {
				try {
					return jacksonObjectMapper.writeValueAsString(value);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
