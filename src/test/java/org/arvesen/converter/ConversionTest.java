package org.arvesen.converter;

import junit.framework.TestCase;

public class ConversionTest extends TestCase {

	public void testUMT32XYToLatitudeLongitudeConversion() {
		Conversion conversion = new Conversion();
		double x = 603022;
		double y = 6643801;
		boolean southhemi = false;
		int zone = 32;

		double latlon[] = conversion.UTMXYToLatLon( x, y, zone, southhemi );
		System.out.println( "Latitude = " + latlon[0] + ", longitude = " + latlon[1] );
		assertNotNull( latlon );

		assertTrue( new Double( latlon[0] ).compareTo( new Double( 59.00 ) ) == 1 );
		assertTrue( new Double( latlon[0] ).compareTo( new Double( 60.00 ) ) == -1 );

		assertTrue( new Double( latlon[1] ).compareTo( new Double( 10.00 ) ) == 1 );
		assertTrue( new Double( latlon[1] ).compareTo( new Double( 11.00 ) ) == -1 );

	}

	
	public void testLatitudeLongitudeToUMT32XYConversion() {
		Conversion conversion = new Conversion();
		double longitude = 10.8426554183903;
		double latitude = 59.91879220651894;
		int zone = 32;

		double xy[] = conversion.LatLonToUTMXY(latitude, longitude, zone );
		System.out.println( "X = " + xy[0] + ", Y = " + xy[1] );
		assertNotNull( xy );

		System.out.println( new Double( xy[0] ).compareTo( new Double( 603023 ) ) );
		
		assertTrue( new Double( xy[0] ).compareTo( new Double( 603022 ) ) == 1 );
		assertTrue( new Double( xy[0] ).compareTo( new Double( 603023 ) ) == -1 );

		assertTrue( new Double( xy[1] ).compareTo( new Double( 6643801 ) ) == 1 );
		assertTrue( new Double( xy[1] ).compareTo( new Double( 6643802 ) ) == -1 );

	}

}
