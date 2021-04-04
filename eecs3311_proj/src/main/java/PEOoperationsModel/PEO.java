package PEOoperationsModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * REQ: 4.8 Managing parking Space
 * 		4.8.3-REQ-1: The user must be an authenticated parking enforcement officer.   [done in REQ: 4.3]
 * 		4.8.3-REQ-2: Parking enforcement officers must verify a parking space is vacant before removing it from the system
 * 		4.8.3-REQ-3: The system must have a minimum of one parking space
 * 		4.8.3-REQ-4: Parking enforcement officers must verify requested parking space is vacant in the system before granting requests
 */
public class PEO {
	
	private static String bookingPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";				// fix this later -> turn to relative path
//	private static List<String> parkingSpot = Arrays.asList(new String[1500]);
//	private static ArrayList<String> parkingSpot;
	private static String[] parkingspot = new String[50];
	
			
 	/* 4.8.3-REQ-4
	 * add parking spot to the "THINK ABOUT THIS"
	 * spotName convention -> location abreviation + num[1-1500]
	 * eg: york78 [location: york, spot number:78]
	 * STATIC for testing purposes REMOVE LATER
	 */
	public void addSpaces(String spotName) throws IOException {
		
		//FIX THIS
		System.out.println("BEFORE= " + Arrays.toString(parkingspot));
		for (int i = 0; i < parkingspot.length; i++) {
			parkingspot[i] = spotName;
			break;
		}
		System.out.println("AFTER= " +Arrays.toString(parkingspot));
	}
	
	/* 4.8.3-REQ-2:
	 * Remove parking spot from booking.csv
	 */
	public static void removeSpaces(String spotName) {
		// FIX THIS
//		System.out.println("BEFORE= " + Arrays.toString(parkingspot));
//		System.out.println("AFTER= " +Arrays.toString(parkingspot));
	}
	
	/*
	 * Gives count of the available spot
	 */
	public int countParkingSpace() {
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("PEO");
//		addSpaces("york75");
//		removeSpaces("york75");
	}
}
