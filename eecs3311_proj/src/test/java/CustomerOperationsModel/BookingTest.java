package CustomerOperationsModel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookingTest {
	
	Booking booking;
	private static String path = "../eecs3311_proj/CSVs/booking.csv";	

	
	@Test
	public void test() {
		booking = new Booking();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@SuppressWarnings("unused")
	public void checkSpaces() {
		String spotName = "";
		if (spotName == null) {
			expectedEx.expectMessage("spotName is null");
		} else {
			booking.checkParkingSpace(spotName);
			expectedEx.expectMessage("spotName is not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void bookSpaces() throws IOException {
		String userName = ""; 
		String bookingID = ""; 
		String date = ""; 
		String time = ""; 
		String duration = ""; 
		String spotName = ""; 
		String price = "";  
		String paymentStat = "";  
		String licenceNum = ""; 
		
		if (spotName == null) {
			expectedEx2.expectMessage("spotName is null");
		} else {
			booking.bookparkingSpace(userName,bookingID,date,time, duration,spotName,price,paymentStat,licenceNum);
			expectedEx2.expectMessage("spotName is not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx3 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void userCount() {
		String userName = "";
		if (userName == null) {
			expectedEx3.expectMessage("username is null");
		} else {
			booking.userCount(userName);
			expectedEx3.expectMessage("username is not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx4 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void bookingID() {
		if (booking.bookingID() == null) {
			expectedEx3.expectMessage("username is null");
		} else {
			expectedEx3.expectMessage("username is not null");
		}
	}
}
