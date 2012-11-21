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

}
