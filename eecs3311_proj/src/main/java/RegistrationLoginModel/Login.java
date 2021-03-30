package RegistrationLoginModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Class reads and authenticates the user from the csv files
 * customer reads from customer.csv
 * PEO reads from PEO.csv
 */
public class Login {
	
	private User user;
	private String userPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/customer.csv";		// fix this later -> turn to relative path
	private Scanner f;
	
	
	/*
	 * Authenticates and verifies the users existance 
	 */
	public String[] authenticate(String userName, String password) {
		String line = "";
		String[] val = null;
		
		boolean isExists = false;
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(userPath));
			while ((line = bfr.readLine()) != null) {
				val = line.split(",");
				System.out.println("userName:" + val[4] + "  "+  "password:" + val[7]);
				
				List<String> lst = Arrays.asList(val);
				System.out.println(lst);
				if (lst.contains(userName) && lst.contains(password)) {
					isExists = true;
				} else {
					isExists = false;
				}
				System.out.println("is exists = " + isExists);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	
//	public void authenticate(String username, String password) {
//		boolean isExists = false;
//		String uName = "";
//		String pswd = "";
//		
//		// reading the CSV file
//		try {
//			f = new Scanner(new File(userPath));			// reads the file 
//			f.useDelimiter("[,\n]");						// reads through the comma 
//			
//			while (f.hasNext() && !isExists) {
//				uName = f.next();
//				pswd = f.next();
//				
//				if (uName.trim().equals(username.trim()) && pswd.trim().equals(pswd.trim())) {
//					isExists = true;
//					System.out.println("User exists");
//				} else {
//					isExists = false;
//					System.out.println("User doesn't exists");
//				}
//			}
//			f.close();
//			System.out.println(isExists);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public static void main(String[] args) {
		System.out.println("Login");
		Login login = new Login();
		System.out.println(login.userPath);
		
		String user = "farhan95";
		String password = "User1";
		System.out.println(login.authenticate(user, password));
	}
}
