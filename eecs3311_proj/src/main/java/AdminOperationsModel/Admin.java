package AdminOperationsModel;

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
import java.util.Scanner;

/*
 * REQ: 4.1
 * 		4.1.3-REQ-1: The system must assign a unique ID to each new parking enforcement officer added  [this is the username the user puts in]
 * 		4.1.3-REQ-2: The system must verify the parking enforcement officer exists in the system before removing an officer
 * 		4.1.3-REQ-3: The system must verify a new parking enforcement officer’s ID does not exist in the system already
 * 		4.1.3-REQ-4: The system must store a new parking enforcement officer’s registration information
 */
public class Admin {
	
	private static String userPath = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/database.csv";		// fix this later -> turn to relative path
	private static Scanner x;
	
	
	/*
	 * 4.1.3-REQ-2: The system must verify the parking enforcement officer exists in the system before removing an officer
	 * 4.1.3-REQ-3: The system must verify a new parking enforcement officer’s ID does not exist in the system already
	 * 		LIKE ISEXISTS() METHOD
	 * 		BASICSLLY -> CHECK THE USERNAME COLUMN
	 * 		Authenticates and verifies the users existance in database.csv
	 */
	// for testing turn is to static void
	public void authenticate(String userName, String password) {
		String line = "";
		String[] val = null;
		boolean isExists = false;
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(userPath));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
//				System.out.println("userName:" + val[3] + ",  "+ "userType:" + val[1] + ", " +  "password:" + val[6]);
				
				// convert the array into list and put the val into the arraylists
				List<String> lst = Arrays.asList(val);
				System.out.println(lst);
				System.out.println("userName:" + lst.get(3) + ",  "+ "userType:" + lst.get(1) + ", " +  "password:" + lst.get(6));
				
				// check if the list index 4(username) and index 7(password) contains the input  [&& lst.get(6).contains(password)]
				if (lst.get(3).contains(userName) ) {
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
	 * REQ:4.1 writes the user details to the database file
	 * table schema: 
	 * Name | usertype | email | username | Phone number | Address | password
	 */
	public void writeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password) throws IOException {
		
		File fw = new File(userPath);						// path to the file
		FileWriter fwt = new FileWriter(fw, true);
		BufferedWriter bfw = new BufferedWriter(fwt);
		PrintWriter pw = new PrintWriter(bfw);				// prints to the file
		x = new Scanner(new File(userPath));
		x.useDelimiter("[,\n]");
		
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
	
	/* REQ:4.1:
	 * Remove PEO from database.csv
	 * FIX THIS
	 */
	public void removeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password) {
//		// FIX THIS
//		String tmpFile = "tmp.csv";
//		String target = "";
//		File oldFile = new File(userPath);
//		File newFile = new File(tmpFile);
//		
//		System.out.println(userName);
//		try {
//			FileWriter fw = new FileWriter(tmpFile, true);
//			BufferedWriter bfw = new BufferedWriter(fw);
//			PrintWriter pw = new PrintWriter(bfw);
//			x = new Scanner(new File(userPath));
//			x.useDelimiter("[,\n]");
//			
//			while (x.hasNext()) {
//				target = x.next();
//				if (!target.equals(userName)) {
//					pw.printf("%s,%s,%s,%s,%s,%s,%s\n", name, userType,email,userName,phoneNumber,address,password);
//				}
//			}
//			x.close();
//			pw.flush();
//			pw.close();
//			oldFile.delete();
//			File dmp = new File(userPath);
//			newFile.renameTo(dmp);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Admin");
	}

}
