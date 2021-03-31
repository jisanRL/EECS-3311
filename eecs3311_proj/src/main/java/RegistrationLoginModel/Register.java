package RegistrationLoginModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
	
	private static User user;  // composition 
	private static String userPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/PEO.csv";		// fix this later -> turn to relative path
	
	/*
	 * writes the user to the file
	 */
	public static void writeUser(String firstName, String lastName, 
			String email, String phoneNumber, String address, 
			String userName, String password) throws FileNotFoundException {
		
		File fw = new File(userPath);			// path to the file
		PrintWriter pw = new PrintWriter(fw);	// prints to the file
		
		
		ArrayList<User> theuser = new ArrayList<User>();
//		theuser.add(user.setFirstName(firstName));
//		theuser.add(lastName);
//		theuser.add(email);
//		theuser.add(phoneNumber);
//		theuser.add(address);
//		theuser.add(userName);
//		theuser.add(password);
		System.out.println(theuser);
		
		for (User str : theuser) {
//			pw.printf("%s,%s,%s,%s,%s,%s,%s\n", theuser.getFirstName(), theuser.getLastName(), theuser.getEmail(), theuser.getPhoneNumber()), theuser.getAddress(), theuser.getUserName(), theuser.getPassword());	// prints to the file 
		}
		pw.close();		//close file
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("register");
		
		String firstName = "jason";
		String lastName = "applesead";
		String email = "jason@yorku.ca";
		String phoneNumber = "2134141413";
		String address = "12 apple st";
		String userName = "jason12";
		String password = "peo1";
		writeUser(firstName,lastName,email,phoneNumber,address,userName,password);
	}
}
