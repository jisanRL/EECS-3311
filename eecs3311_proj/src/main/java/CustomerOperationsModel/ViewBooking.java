package CustomerOperationsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	 * display 
	 */
	public List<String> viewBooking() {
		String line = "";
		String[] val = null;
		List<String> lst = new ArrayList<String>();
		
		// FIX THIS
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine()) != null) {
				val = line.split(",");
				
				String pp = val[0] + "  " + val[3] + "  " + val[4] + "  " + val[5] ;
				// convert the array into list and put the val into the arraylists
				// val[0] + " Booking Time: " + val[3] + "  Duration: " + val[4]+ " Spot: " + val[5] + " Price: " + val[6];
//				lst = Arrays.asList(val);
				lst.add(pp);
				System.out.println(lst);
				
				
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
				val = new String[20];
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
