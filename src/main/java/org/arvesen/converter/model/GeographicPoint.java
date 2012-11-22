package org.arvesen.converter.model;

public class GeographicPoint {
	private double longitude;
	private double latitude;

	public GeographicPoint(double d, double e) {
		setLatitude( d );
		setLongitude( e );
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude( double longitude ) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude( double latitude ) {
		this.latitude = latitude;
	}

}
