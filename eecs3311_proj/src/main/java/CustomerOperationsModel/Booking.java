package CustomerOperationsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * REQ 4.4 Booking a parking space
 * 		4.4.3-REQ-1: Customer must be registered and logged-in before booking a parking space   [done in REQ 4.2 and 4.3]
 * 		4.4.3-REQ-2: Customer must select which parking space they are booking
 * 		4.4.3-REQ-3: If the customer selects a parking space which is occupied, they are presented with an error message and must select a new space  [DONE IN CLIENT SIDE]
 * 		4.4.3-REQ-4: Customer must enter how long they want to book said parking space for
 * 		4.4.3-REQ-5: The system allows a customer to book up to three parking spaces  [in a given location;ie.3 space in york at a time]
 * 		4.4.3-REQ-6: Each booked parking space receives a unique booking ID
 * 		4.4.3-REQ-7: The system must display an error message if the parking space the customer booked is occupied in the system
 */
public class Booking {
	
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";		// fix this later -> turn to relative path

	/* 4.4.3-REQ-2 
	 * READS THHROUGH BOOKING.CSV INDEX 4 AND SEES IF THE ENTERED SPOT IS THERE OR NOT
	 * REMOVE STATIC AFTER TESTING
	 */
	public boolean checkParkingSpace(String spotName) {
		//FIX THIS
		String line = "";
		String[] val = null;
		boolean isExists = false;
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");
//				System.out.println("userName:" + val[3] + ",  "+ "userType:" + val[1] + ", " +  "password:" + val[6]);
				
				// convert the array into list and put the val into the arraylists
				List<String> lst = Arrays.asList(val);
				System.out.println(lst);
				System.out.println("spotName:" + lst.get(4));
				
				// check if the list contains index 4(spotName) and index 7(password) contains the input
				if (lst.get(4).contains(spotName)) {
					isExists = true;
					String msg = "Spot is occupied";
					System.out.println("is exists = " + isExists + "; " + msg);
					break;
				} else {
					String msg = "Spot is free";
					System.out.println("is exists = " + isExists + "; " + msg);
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
	
	/*  4.4.3-REQ-4 */
	public int bookingDuration() {
		return 0;
	}
	
	/*
	 * 4.4.3-REQ-5: The system allows a customer to book up to three parking spaces  [in a given location;ie.3 space in york at a time]
	 * 4.4.3-REQ-7: The system must display an error message if the parking space the customer booked is occupied in the system
	 * BOOKING.CSV schema -> USERNAME,BOOKINGID,DATE,DURATION ,BOOKING SPOT,PRICE,PAYMENT STATUS , LICENSE NUMBER
	 */
	public int bookparkingSpace() {
		return 0;
	}
	
	/* 4.4.3-REQ-6  */
	public int bookingNumber() {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Booking Backend");
		
		Booking bk = new Booking();
		String spotName= "york12";
		bk.checkParkingSpace(spotName);
		
	}
}
