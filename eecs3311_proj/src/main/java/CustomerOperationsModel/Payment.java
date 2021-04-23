package CustomerOperationsModel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Req: 4.6  : calulates the payment/price of the parking 
 * 		4.6.3-REQ-1: Customer must be registered and logged-in before making a payment  [[done in REQ 4.2 and 4.3]]
 * 		4.6.3-REQ-2: Customer must have entered additional information such as which parking space they are booking before making payment [Done in booking class]
 * 		4.6.3-REQ-3: The system must accept different forms of payment (ex: Paypal, credit, debit, etc.)
 * 		4.6.3-REQ-4: The system must automatically timestamp each payment confirmation
 * 		4.6.3-REQ-5: The system automatically starts a countdown till expiry once payment is confirmed	
 * 		4.6.3-REQ-6: The system allows a customer to pay for multiple parking space bookings (if any) cumulatively
 * 		4.6.3-REQ-7: The system must authenticate   [done in Login and authentication part, redo here]
 */
public class Payment {
	
	/* 4.6.3-REQ-3 */
	public double price(double duration) {
		double prc = 0.0;
		if (duration < 1 || duration > 24) {
			throw new IllegalArgumentException("Timing has to be between 1 to 24 hrs");
		}
		// price -> $2/hr
		prc = 2 * duration;
		return prc;
	}
	
	// to be done in the client side
	public String selectPaymentMethod() {
		return null;
	}
	
	/*	4.6.3-REQ-4: Time stamp current tie 
	 *	EXECUTES WHEN THE PAY BUTTON IS CLICKED
	 */
	public String timeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());	// gets the current time
		System.out.println(ts);
		return ts.toString();
	}
	
	/*  4.6.3-REQ-5 
	 *  STARTS EXECUTING WHEN THE PAY BUTTON IS CLICKED
	 *  Add time to the current time 
	 *  This calculates the expire time 
	 * */
	public String counter(int duration) {
		Calendar calendar = Calendar.getInstance();
//	    System.out.println("Current Date = " + calendar.getTime());
	    calendar.add(Calendar.HOUR_OF_DAY, +duration);
	    System.out.println("Updated Date = " + calendar.getTime());
	    return calendar.toString();
	}
	
	/* 4.6.3-REQ-7: */
	public void authenticate() {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Payment");
		
		Payment pay = new Payment();
		System.out.println(pay.price(24));
		
		pay.timeStamp();
		pay.counter(4);
	}


}
