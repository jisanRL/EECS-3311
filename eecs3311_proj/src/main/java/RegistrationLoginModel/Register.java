package RegistrationLoginModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Class writes the user to the csv file
 * PEO goes to database.csv
 *
 *  REMOVE ALL THE STATICS BEFORE FINAL SUBMISSION
 *  https://www.youtube.com/watch?v=v-qCbMRkk-s
 */
public class Register {
	
	private static User user;  			// composition 
	private static String userPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/database.csv";		// fix this later -> turn to relative path
	
	/*
	 * writes the user details to the database file
	 */
	public void writeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password) throws IOException {
		
		File fw = new File(userPath);						// path to the file
		FileWriter fwt = new FileWriter(fw, true);
		BufferedWriter bfw = new BufferedWriter(fwt);
		PrintWriter pw = new PrintWriter(bfw);				// prints to the file
		
		if (fw.exists() == false) {
			fw.createNewFile();
			System.out.println("File exists");
		} else {
			System.out.println("File doesn't exist");
		}
		pw.printf("%s,%s,%s,%s,%s,%s,%s\n", name, userType,email,userName,phoneNumber,address,password);		// writes to the file
		pw.flush();		// flushes the data into the csv
		pw.close();		//close file
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
