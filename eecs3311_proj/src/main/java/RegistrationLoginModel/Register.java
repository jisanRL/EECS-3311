package RegistrationLoginModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Interfaces.CSVOps;

/*
 * Class writes the user to the csv file
 * PEO goes to database.csv
 *
 */
public class Register implements CSVOps {
	
	private static User user;  			// composition 
	private static String userPath = "../eecs3311_proj/CSVs/database.csv";
	
	/*
	 * writes the user details to the database file
	 * table schema:  Name | usertype | email | username | Phone number | Address | password
	 */
	public void writeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password) throws IOException {
		
		File fw = new File(userPath);						// path to the file
		FileWriter fwt = new FileWriter(fw, true);
		BufferedWriter bfw = new BufferedWriter(fwt);
		PrintWriter pw = new PrintWriter(bfw);				// prints to the file
		
		if (!fw.exists()) {
			fw.createNewFile();
			System.out.println("File exists");
		} else {
			System.out.println("File doesn't exist");
		}
		pw.printf("%s,%s,%s,%s,%s,%s,%s\n", name, userType,email,userName,phoneNumber,address,password);		// writes to the file
		pw.flush();		// flushes the data into the csv
		pw.close();		//close file
	}
	
	// do nothing 
	public void removeUser(String name, String userType, String email, String userName, String phoneNumber,
			String address, String password) {
		// TODO Auto-generated method stub
	}
	public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration,
			String spotName, String price, String paymentStat, String licenceNum, String paymentType) {
		// TODO Auto-generated method stub
	}

	public void cancelBooking(String userName, String bookingID, String date, String time, String duration,
			String spotName, String price, String paymentStat, String licenceNum) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) throws IOException {
			System.out.println("register");
			
			String name = "tom car";
			String userType = "PEO";
			String email = "tom@yorku.ca";
			String phoneNumber = "2133141413";
			String address = "17 apple st";
			String userName = "cat12";
			String password = "peo54";
	//		writeUser(name, userType,email,userName,phoneNumber,address,password);
		}
}
