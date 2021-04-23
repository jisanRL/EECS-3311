package CustomerOperationsModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Interfaces.CSVOps;

/*
 * REQ; 4.5
 * 		4.5.3-REQ-1: Customer must be registered and logged-in before cancelling a parking space  [[done in REQ 4.2 and 4.3]]
 * 		4.5.3-REQ-2: Customer must enter the booking ID which is associated with their name
 * 		4.5.3-REQ-3: The cancellation can only go through if the time of cancellation is before the booking expiry time
 */
public class Cancelbooking implements CSVOps {
	
	private static String path = "../eecs3311_proj/CSVs/booking.csv";
	private static Scanner x;
	
	/* 4.5.3-REQ-2 
	 * CANCELS THE ENTIRE BOOKING BY DELETING THE ROW IN BOOKING.CSV
	 * UNIQUE VALUE -> BOOKING SPOT
	 * WORKS WHEN CANCEL BOOKING BUTTON IS CLICKED
	 */
	public void cancelBooking(String userName, String bookingID, String date, String time, 
			String duration,String spotName, String price, String paymentStat, String licenceNum) {
		
		String tmpFile = "tmp.csv";
		String target1 = ""; String target2 = ""; String target3 = ""; String target4 = ""; 
		String target5 = "";String target6 = "";String target7 = "";String target8 = "";String target9 = "";String target10 = "";
		File oldFile = new File(path);
		File newFile = new File(tmpFile);
		
		System.out.println(spotName);
		try {
			FileWriter fw = new FileWriter(tmpFile, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bfw);
			x = new Scanner(new File(path));			// reads/scans the file 
			x.useDelimiter("[,\n]");						// write each field separated by newline or comma 
			
			// scan the file till the end
			while (x.hasNext()) {
				target1 = x.next();		// username
				target2 = x.next();		// bookingID
				target3 = x.next();		// date
				target4 = x.next();		// time
				target5 = x.next();		// duration
				target6 = x.next();		// spotName
				target7 = x.next();		// price
				target8 = x.next();		// paymentStat
				target9 = x.next();		// licenceNum
				
				// if the target is not equals the input credentials then write all the other lines accept for the line that mathches the inputs  
				if (!target2.equals(bookingID) && !target3.equals(date) && !target4.equals(time) && !target5.equals(duration) && !target6.equals(spotName)&& !target7.equals(price) && !target8.equals(paymentStat) && !target9.equals(licenceNum)){
					pw.println(target1 + ","+ target2 + "," + target3 + ","+ target4 + "," + target5 + ","+ target6 + "," + target7 + ","+ target8 + "," + target9);
				}		
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();				// delete the old file
			File dmp = new File(path);		// recreate a file in the path
			newFile.renameTo(dmp);			// rename the new file to old file's name					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/* 4.5.3-REQ-3 */
	public boolean checkTiming() {
		return false;
	}

	public void writeUser(String name, String userType, String email, String userName, String phoneNumber,
			String address, String password) throws IOException {
		// TODO Auto-generated method stub
	}

	public void removeUser(String name, String userType, String email, String userName, String phoneNumber,
			String address, String password) {
		// TODO Auto-generated method stub
	}

	public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration,
			String spotName, String price, String paymentStat, String licenceNum, String paymentType) {
		// TODO Auto-generated method stub	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cancel Booking");
	}
}
