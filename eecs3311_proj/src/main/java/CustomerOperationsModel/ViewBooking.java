package CustomerOperationsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
 * REQ-4.7
 * 	   4.7.3-REQ-1: Only authorized users, such as parking enforcement officers, can view any customer’s booking details
 * 	   4.7.3-REQ-2: Customers can view their parking space booking information, including expiry time
 * 	   4.7.3-REQ-3: The system must notify the customer when their parking space booking is expired
 */
public class ViewBooking {
	
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";		// fix this later -> turn to relative path

	/*
	 * 4.7.3-REQ-1
	 * both customer and PEO has access to this method
	 */
	public List<String> viewBooking() {
		String line = "";
		String[] val = null;
		List<String> lst = null;
		boolean isExists = false;
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
				
				// convert the array into list and put the val into the arraylists
				lst = Arrays.asList(val);
				System.out.println(lst);
//				System.out.println("userName:" + lst.get(3) + ",  "+ "userType:" + lst.get(1) + ", " +  "password:" + lst.get(6));
				
//				// check if the list index 4(username) and index 7(password) contains the input  [&& lst.get(6).contains(password)]
//				if (lst.get(3).contains(userName) ) {
//					isExists = true;
//					String msg = "User exists";
//					System.out.println("is exists = " + isExists + " " + msg);
//					break;
//				} else {
//					String msg = "User doesn't exist";
//					System.out.println("is exists = " + isExists + " " + msg);
//					isExists = false;
//				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	/*
	 * 4.7.3-REQ-2:
	 */
	public void viewBookingDetails() {
		
	}
	
	/* 4.7.3-REQ-3: */
	public void notifyCustomer() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("View Booking");
		ViewBooking vb = new ViewBooking();
		vb.viewBooking();
	}

}
