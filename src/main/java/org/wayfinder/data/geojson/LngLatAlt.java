package org.wayfinder.data.geojson;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.wayfinder.data.geojson.jackson.LngLatAltDeserializer;
import org.wayfinder.data.geojson.jackson.LngLatAltSerializer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@JsonDeserialize(using = LngLatAltDeserializer.class)
@JsonSerialize(using = LngLatAltSerializer.class)
@Embeddable
public class LngLatAlt {

    @Column(name="longitude")
	private double longitude;

    @Column(name="latitude")
	private double latitude;

    @Column(name="altitude")
	private double altitude = Double.NaN;

	public LngLatAlt() {
	}

	public LngLatAlt(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public LngLatAlt(double longitude, double latitude, double altitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
	}

	public boolean hasAltitude() {
		return !Double.isNaN(altitude);
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
}
