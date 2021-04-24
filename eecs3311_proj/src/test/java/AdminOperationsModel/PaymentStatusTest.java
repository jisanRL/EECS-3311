package AdminOperationsModel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PaymentStatusTest {
	PaymentStatus ps;

	@Test
	public void test() throws Exception {
		ps = new PaymentStatus();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
//	@Test
	public void viewBooking() {
		ps.viewBooking().add("York");
		ps.viewBooking().add("Square one");
		ps.viewBooking().add("Yorkdale");
		ps.viewBooking().add("St George");
		ps.viewBooking().add("Downtown");
		
		if (ps.viewBooking() == null) {
			expectedEx.expectMessage("Null");
		} else {
			expectedEx.expectMessage("Not Null");
		}
	}
	
	@SuppressWarnings("unused")
//	@Test
	public void confirmPayment() throws IOException {
		String name = ""; String email = ""; String parkingspace = "";
		
		if (name == null || email == null || parkingspace == null) {
			expectedEx.expectMessage("Null");
		} else {
			ps.confirmPayment(name, email, parkingspace);
			expectedEx.expectMessage("Not Null");
		}
	}

}
