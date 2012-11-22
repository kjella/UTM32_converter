package org.arvesen.converter;

import junit.framework.TestCase;

import org.arvesen.converter.model.GeographicPoint;

public class ConversionTest extends TestCase {

	public void testUMT32XYToLatitudeLongitudeConversion() {
		Conversion conversion = new Conversion();
		double x = 603022;
		double y = 6643801;
		boolean southhemi = false;
		int zone = 32;

		GeographicPoint point = conversion.UTMXYToLatLon( x, y, zone, southhemi ); 

		System.out.println( "Latitude = " + point.getLatitude() + ", longitude = " + point.getLongitude() );
		assertNotNull( point );

		assertTrue( new Double( point.getLatitude() ).compareTo( new Double( 59.00 ) ) == 1 );
		assertTrue( new Double( point.getLatitude() ).compareTo( new Double( 60.00 ) ) == -1 );

		assertTrue( new Double( point.getLongitude() ).compareTo( new Double( 10.00 ) ) == 1 );
		assertTrue( new Double( point.getLongitude() ).compareTo( new Double( 11.00 ) ) == -1 );

	}

	
	public void testLatitudeLongitudeToUMT32XYConversion() {
		Conversion conversion = new Conversion();
		double longitude = 10.8426554183903;
		double latitude = 59.91879220651894;
		int zone = 32;

		GeographicPoint point = conversion.LatLonToUTMXY(latitude, longitude, zone );
		System.out.println( "X = " + point.getLatitude() + ", Y = " + point.getLongitude() );
		assertNotNull( point );

		System.out.println( new Double( point.getLatitude() ).compareTo( new Double( 603023 ) ) );
		
		assertTrue( new Double( point.getLatitude() ).compareTo( new Double( 603022 ) ) == 1 );
		assertTrue( new Double( point.getLatitude() ).compareTo( new Double( 603023 ) ) == -1 );

		assertTrue( new Double( point.getLongitude() ).compareTo( new Double( 6643801 ) ) == 1 );
		assertTrue( new Double( point.getLongitude() ).compareTo( new Double( 6643802 ) ) == -1 );

	}

}
