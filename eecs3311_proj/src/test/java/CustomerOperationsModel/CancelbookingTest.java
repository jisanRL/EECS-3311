package CustomerOperationsModel;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CancelbookingTest {
	
	private static String path = "../eecs3311_proj/CSVs/booking.csv";
	Cancelbooking cb;

	@Test
	public void test() {
		cb = new Cancelbooking();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void cancelBooking() {
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
			cb.cancelBooking(userName,bookingID,date,time, duration,spotName,price,paymentStat,licenceNum);
			expectedEx2.expectMessage("spotName is not null");
		}
	}
			

}
