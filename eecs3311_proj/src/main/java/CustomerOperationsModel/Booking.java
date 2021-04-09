package CustomerOperationsModel;

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
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * REQ 4.4 Booking a parking space
 * 		4.4.3-REQ-1: Customer must be registered and logged-in before booking a parking space   [done in REQ 4.2 and 4.3]
 * 		4.4.3-REQ-2: Customer must select which parking space they are booking  [DONE]
 * 		4.4.3-REQ-3: If the customer selects a parking space which is occupied, they are presented with an error message and must select a new space  [DONE IN CLIENT SIDE]
 * 		4.4.3-REQ-4: Customer must enter how long they want to book said parking space for  [DONE IN CLIENT SIDE]
 * 		4.4.3-REQ-5: The system allows a customer to book up to three parking spaces  [in a given location;ie.3 space in york at a time]
 * 		4.4.3-REQ-6: Each booked parking space receives a unique booking ID  [DONE]
 * 		4.4.3-REQ-7: The system must display an error message if the parking space the customer booked is occupied in the system [DONE]
 */
public class Booking {
	
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";		// fix this later -> turn to relative path

	/* 4.4.3-REQ-2 
	 * READS THHROUGH BOOKING.CSV INDEX 5 AND SEES IF THE ENTERED SPOT IS THERE OR NOT
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
				System.out.println("spotName:" + lst.get(5));
				
				// check if the list contains index 4(spotName) and index 7(password) contains the input
				if (lst.get(5).contains(spotName)) {
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
	 * BOOKING.CSV schema -> USERNAME,BOOKINGID,DATE,TIME OF BOOKING,DURATION ,BOOKING SPOT,PRICE,PAYMENT STATUS , LICENSE NUMBER
	 */
	public void bookparkingSpace(String userName, String bookingID, String date, String time, 
			String duration,String spotName, String price, String paymentStat, String licenceNum) throws IOException {
		File fw = new File(path);							// path to the file
		FileWriter fwt = new FileWriter(fw, true);
		BufferedWriter bfw = new BufferedWriter(fwt);
		PrintWriter pw = new PrintWriter(bfw);				// prints to the file
		
		if (!fw.exists()) {
			fw.createNewFile();
			System.out.println("File exists");
		} else {
			System.out.println("File doesn't exist");
		}
		
		pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", userName,bookingID,date,time,duration,spotName,price,paymentStat,licenceNum);		// writes to the file
		pw.flush();							// flushes the data into the csv
		pw.close();							//close file
		
	}
	
	// 4.4.3-REQ-5:
//	public void userCount(String userName) {
//		String line = "";
//		String[] val = null;
//		ArrayList<String> user = null;
////		boolean isExists = false;
//		int count = 0;
// 		try {
//			BufferedReader bfr = new BufferedReader(new FileReader(path));
//			while ((line = bfr.readLine())!= null) {
//				val = line.split(",");
//				
//				// convert the array into list and put the val into the arraylists
//				List<String> lst = Arrays.asList(val);
//				System.out.println(lst);
//				System.out.println("userName:" + lst.get(0));
//				
//				// add all the lst element into user 
//				user.addAll(lst);
//				count= Collections.frequency(user, userName);
//				if (count <= 3) {
////					isExists = true;
//					String msg = "Less then 3";
//					count = Collections.frequency(user, userName);
//					System.out.println("count = " + count + " " + msg);
//					break;
//				} else {
//					String msg = "More then 3";
//					count = Collections.frequency(user, userName);
//					System.out.println("count = " + count + " " + msg);
////					isExists = false;
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	/* 4.4.3-REQ-6  */
	public String bookingID() {
		//FIX THIS
		int len = 4;
		String chr = "abcdefghijk0123456789";
		Random rn = new Random();
		StringBuilder str = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			str.append(chr.charAt(rn.nextInt(chr.length())));
		}
			
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Booking Backend");
		
		Booking bk = new Booking();
		String spotName= "york12";
		bk.checkParkingSpace(spotName);
		
		System.out.println(bk.bookingID());
		
		String user = "farhan95";
//		bk.userCount(user);
		
	}
}
