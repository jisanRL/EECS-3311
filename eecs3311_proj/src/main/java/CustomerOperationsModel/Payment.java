package CustomerOperationsModel;

/*
 * Req: 4.6
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
	public String selectPaymentMethod() {
		return null;
	}
	
	/*	4.6.3-REQ-4: Time stamp current time */
	public void timeStamp() {
		
	}
	
	/*  4.6.3-REQ-5 */
	public void counter() {
		
	}
	
	/* 4.6.3-REQ-7: */
	public void authenticate() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Payment");
	}

}
