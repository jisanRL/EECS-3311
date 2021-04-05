package PEOoperationsModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/bookingpeo.csv";				// fix this later -> turn to relative path
	private static List<String> parkingspot = Arrays.asList(new String[1500]);
//	private static ArrayList<String> parkingspot;
//	private static String[] parkingspot = new String[1500];
	private final int spotPerLocation = 1500;
			
	
 	/* 4.8.3-REQ-4
	 * add parking spot to the bookingpeo.csv
	 * spotName convention -> location abreviation + num[1-1500] eg: york78 [location: york, spot number:78]
	 * table schema ->   spotname
	 */
	public void addSpaces(String spotName) throws IOException {
		
		//FIX THIS
		File fw = new File(path);							// path to the file
		FileWriter fwt = new FileWriter(fw, true);
		BufferedWriter bfw = new BufferedWriter(fwt);
		PrintWriter pw = new PrintWriter(bfw);				// prints to the file
		
		if (!fw.exists()) {
			fw.createNewFile();
			System.out.println("File exists");
		} else {
			System.out.println("File doesn't exist");
		}
		pw.printf("%s\n", spotName);		// writes to the file
		pw.flush();							// flushes the data into the csv
		pw.close();							//close file
	}
	
	
	/* 4.8.3-REQ-2:
	 * Remove parking spot from booking.csv
	 */
	public void removeSpaces(String spotName) {
		// FIX THIS
		String line = "";
		String[] val = null;
		int cnt = 0;
		ArrayList<ArrayList<String>> vp = new ArrayList<ArrayList<String>>();
		
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine()) != null) {
				val = line.split(",");
				// checks the entire column for spotname
				if (spotName.equals(val[0])) {
					ArrayList<String> q = new ArrayList<String>();
					for (String str : q) {
						q.add(str);
					}
					vp.add(q);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(vp.toString());
		
		//re-write the whole file again after deleting the spot
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bfw);
			
			for (ArrayList<String> arrayList : vp) {
				pw.println(vp.get(0));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Gives count of the available spot
	 */
	public int countParkingSpace() {
		int counter = 0;
		if (parkingspot == null) {
			return spotPerLocation;
		} else {
			
			for (String str : parkingspot) {
				if (parkingspot != null) {
					counter++;
				}
			}
		}
		return 1500 - counter ;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("PEO");
//		addSpaces("york75");
//		removeSpaces("york75");
	}
}
