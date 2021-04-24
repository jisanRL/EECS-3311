package CustomerOperationsModel;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PaymentTest {
	
	Payment payment;
	
	@Test
	public void test() {
		payment = new Payment();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void price() {
		double duration = 0.0;
		
		if (duration < 1 || duration > 24) {
			expectedEx2.expectMessage("Null");
		} else {
			payment.price(duration);
			expectedEx2.expectMessage("Not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx3 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void timestamp() {
		if (payment.timeStamp() == null) {
			expectedEx3.expectMessage("Null");
		} else {
			expectedEx3.expectMessage("Not null");
		}
	}
	
	@Rule
	public ExpectedException expectedEx4 = ExpectedException.none();
	@SuppressWarnings("unused")
	public void counter() {
		int duration = 0;
		if (duration == 0 || duration < 0) {
			expectedEx4.expectMessage("Null");
		} else {
			payment.counter(duration);
			expectedEx4.expectMessage("Not null");
		}
	}
	

}
