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

import Interfaces.CSVOps;
import Interfaces.Security;

/*
 * REQ: 4.1
 * 		4.1.3-REQ-1: The system must assign a unique ID to each new parking enforcement officer added  [this is the username the user puts in]
 * 		4.1.3-REQ-2: The system must verify the parking enforcement officer exists in the system before removing an officer
 * 		4.1.3-REQ-3: The system must verify a new parking enforcement officer’s ID does not exist in the system already
 * 		4.1.3-REQ-4: The system must store a new parking enforcement officer’s registration information
 */
public class Admin implements Security, CSVOps {
	
	private static String userPath = "../eecs3311_proj/CSVs/database.csv";	
	private static Scanner x;
	
	
	/*
	 * 4.1.3-REQ-2: The system must verify the parking enforcement officer exists in the system before removing an officer
	 * 4.1.3-REQ-3: The system must verify a new parking enforcement officer’s ID does not exist in the system already
	 * 		LIKE ISEXISTS() METHOD
	 * 		BASICSLLY -> CHECK THE USERNAME COLUMN
	 * 		Authenticates and verifies the users existance in database.csv
	 */
	public boolean authenticate(String userName, String password) {
		String line = "";
		String[] val = null;
		boolean isExists = false;
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(userPath));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
				
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
		return isExists;
	}
	
	
	/*
	 * REQ:4.1 writes the user(PEO) details to the database file
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
	
		String tmpFile = "tmp.csv";
		String target1 = ""; String target2 = ""; String target3 = ""; String target4 = ""; String target5 = "";String target6 = "";String target7 = "";
		String target = "";
		File oldFile = new File(userPath);
		File newFile = new File(tmpFile);
		
		System.out.println(userName);
		try {
			FileWriter fw = new FileWriter(tmpFile, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bfw);
			x = new Scanner(new File(userPath));			// reads/scans the file 
			x.useDelimiter("[,\n]");						// write each field separated by newline or comma 
			
			// scan the file till the end
			while (x.hasNext()) {
				target1 = x.next();		// name
				target2 = x.next();		// usertype
				target3 = x.next();		// email
				target4 = x.next();		// username
				target5 = x.next();		// phoneNumber
				target6 = x.next();		// address
				target7 = x.next();		// password
				
				// if the target is not equals the input credentials then write all the other lines accept for the line that mathches the inputs  
				if (!target1.equals(name)  && !target3.equals(email) && !target4.equals(userName) && !target5.equals(phoneNumber) && !target6.equals(address) && !target7.equals(password)) {
					pw.println(target1 + ","+ target2 + "," + target3 + ","+ target4 + "," + target5 + ","+ target6 + "," + target7);
				}		
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();				// delete the old file
			File dmp = new File(userPath);	// recreate a file in the path
			newFile.renameTo(dmp);			// rename the new file to old file's name					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration,
			String spotName, String price, String paymentStat, String licenceNum, String paymentType) {
		// TODO Auto-generated method stub
	}


	public void cancelBooking(String userName, String bookingID, String date, String time, String duration,
			String spotName, String price, String paymentStat, String licenceNum) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Admin");
	}
}
