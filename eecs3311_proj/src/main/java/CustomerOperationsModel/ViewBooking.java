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
	
	private static String path = "../eecs3311_proj/CSVs/booking.csv";	

	/*
	 * 4.7.3-REQ-1
	 * both customer and PEO has access to this method
	 * display parking space booking information, including expiry time
	 */
	public List<String> viewBooking(String userName) {
		String line = "";
		String[] val = null;
		List<String> lst = new ArrayList<String>();
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine()) != null) {
				val = line.split(",");
				
				if (val[0].contains(userName)) {
					String pp = val[0] + "  ,  " + val[3] + "  ,  " + val[4] + "hrs" + "  ,  " + val[5] + "  ,  " + "$"+ val[6];
					lst.add(pp);
					System.out.println(lst);
				}
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
	
	
	/* 4.7.3-REQ-3: */
	public void notifyCustomer() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("View Booking");
		ViewBooking vb = new ViewBooking();
		String username = "farhan95";
		vb.viewBooking(username);
	}

}
