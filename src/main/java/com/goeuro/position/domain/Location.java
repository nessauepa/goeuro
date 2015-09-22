package com.goeuro.position.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	@JsonProperty("_id")
	private Long id;

	private String name;

	private String type;

	@JsonProperty("geo_position")
	private GeoPosition geoPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", type=" + type + ", geoPosition=" + geoPosition + "]";
	}
}
