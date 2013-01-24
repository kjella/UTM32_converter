package org.arvesen.converter;

import java.util.Random;

import org.arvesen.converter.model.GeographicPoint;

public class ConverterApp {

	public static void main(String[] args) {
		System.out.println("Checking 100 conversion ...");
		long startMS = System.currentTimeMillis();
		
		for ( int i = 0; i < 100; i++) {
			Random generator = new Random( );
			Conversion conversion = new Conversion();
			double x = generator.nextDouble() * 60;
			double y = generator.nextDouble() * 60;
//			System.out.println( "X = " + x + ", Y = " + y );
			boolean southhemi = false;
			int zone = 32;

			GeographicPoint point = conversion.UTMXYToLatLon( x, y, zone, southhemi );
			System.out.println( "Latitude = " + Conversion.RadToDeg( point.getLatitude() ) + ", longitude = " + Conversion.RadToDeg( point.getLongitude() ) );
		}
		
		long stopMS = System.currentTimeMillis();
		System.out.println("Time taken " + ( stopMS - startMS ) + " ms");
	}
	
}