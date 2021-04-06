package AdminOperationsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * REQ: 4.9
 * 		4.9.3-REQ-1: The user must be an systems administrator. [Done in the login part]
 * 		4.9.3-REQ-2: The system must verify the customer’s existence before changing their payment status.
 * 		4.9.3-REQ-3: The system must verify the customer’s occupancy of the parking space before changing their payment status
 * 		4.9.3-REQ-4: The system must verify the customer’s payment of the parking space before changing their payment status
 */
public class PaymentStatus {
	
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";				// fix this later -> turn to relative path
	
	/*	
	 * 	FIX THIS
	 * 4.9.3-REQ-2:Authenticates and verifies the users existance in the booking.csv
	 * 4.9.3-REQ-3:
	 * BASICALLY -> check the 6th index of the csv array for booking status and 4th index for bookingspot
	 */
	// for testing turn is to static void
	public void authenticate(String userName, String password) {
		String line = "";
		String[] val = null;
		boolean isExists = false;
		ArrayList<String> user = null;		// the final output of name, usertype and password
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
//				System.out.println("userName:" + val[3] + ",  "+ "userType:" + val[1] + ", " +  "password:" + val[6]);
				
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
//		return val;
	}
	
	/*
	 * 4.9.3-REQ-4: The system must verify the customer’s payment of the parking space before changing their payment status
	 * BASICALLY -> go through the booking.csv and check index6 of the array 
	 * 		if the status = yes 
	 * 			do nothing 
	 *		if status = no 
	 *			change status to yes
	 */
	public void confirmPayment() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("PAYMENT STATUS");
	}

}
