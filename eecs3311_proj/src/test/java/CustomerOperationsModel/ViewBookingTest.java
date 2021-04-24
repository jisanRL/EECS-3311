package CustomerOperationsModel;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ViewBookingTest {
	
	private static String path = "../eecs3311_proj/CSVs/booking.csv";	
	ViewBooking vb;
	
	@Test
	public void test() {
		vb = new ViewBooking();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
//	@Test
	public void viewBooking() {
		String username = "";
		vb.viewBooking(username).add("York");
		vb.viewBooking(username).add("Square one");
		vb.viewBooking(username).add("Yorkdale");
		vb.viewBooking(username).add("St George");
		vb.viewBooking(username).add("Downtown");
		
		if (vb.viewBooking(username) == null) {
			expectedEx.expectMessage("Null");
		} else {
			expectedEx.expectMessage("Not Null");
		}
	}
}
