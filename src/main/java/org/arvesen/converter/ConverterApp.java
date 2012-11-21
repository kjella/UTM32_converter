package org.arvesen.converter;

import java.util.Random;

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

			double[] latlon = conversion.UTMXYToLatLon( x, y, zone, southhemi );
			System.out.println( "Latitude = " + conversion.RadToDeg( latlon[0] ) + ", longitude = " + conversion.RadToDeg( latlon[1] ) );
		}
		
		long stopMS = System.currentTimeMillis();
		System.out.println("Time taken " + ( stopMS - startMS ) + " ms");
	}
	
}