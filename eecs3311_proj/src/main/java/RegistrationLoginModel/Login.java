package RegistrationLoginModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Class reads and authenticates the user from the csv files
 * PEO reads from database.csv
 * REMOVE ALL THE STATICS BEFORE FINAL SUBMISSION
 */
public class Login {
	
	private User user;			// composition 
	
	/*push the username, userType and password into the AL and verify from here */
	private ArrayList<String> userName;
	private ArrayList<String> userType;
	private ArrayList<String> password;
	
	private static String userPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/database.csv";		// fix this later -> turn to relative path
	
	
	/*
	 * Authenticates and verifies the users existance 
	 */
	// for testing turn is to static void
	public void authenticate(String userName, String password) {
		String line = "";
		String[] val = null;
		boolean isExists = false;
		ArrayList<String> user = null;		// the final output of name, usertype and password
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(userPath));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
				
				// convert the array into list and put the val into the arraylists
				List<String> lst = Arrays.asList(val);
				System.out.println(lst);
				System.out.println("userName:" + lst.get(3) + ",  "+ "userType:" + lst.get(1) + ", " +  "password:" + lst.get(6));
				
				// check if the list index 4(username) and index 7(password) contains the input
				if (lst.get(3).contains(userName) && lst.get(6).contains(password)) {
					isExists = true;
					String msg = "User exists";
					System.out.println("is exists = " + isExists + " " + msg);
					break;
				} else {
					String msg = "User doesn't exist";
					System.out.println("is exists = " + isExists + " " + msg);
					isExists = false;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * checks usertype of the user
	 */
	public String checkUserType(String userName, String password) {
		String line = "";
		String[] val = null;
		String usertype= "";
		
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(userPath));
			while ((line = bfr.readLine()) !=  null) {
				val = line.split(",");				
				// convert the array into list and put the val into the arraylists
				List<String> lst = Arrays.asList(val);

				// check if the list index 3(username) and index 6(password) contains the input
				if (lst.get(3).contains(userName) && lst.get(6).contains(password)) {
					usertype = lst.get(1);
					break;
				} else {
					usertype = null;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("userType= " + usertype);
		return usertype;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Login");
		Login login = new Login();
		System.out.println(login.userPath);
		
		String user = "farhan95";
		String password = "user1";
		login.authenticate(user, password);
		System.out.println("====================================================");
		System.out.println(login.checkUserType(user, password));
	}
}
