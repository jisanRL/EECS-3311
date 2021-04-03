package CustomerOperationsModel;

/*
 * REQ; 4.5
 * 		4.5.3-REQ-1: Customer must be registered and logged-in before cancelling a parking space  [[done in REQ 4.2 and 4.3]]
 * 		4.5.3-REQ-2: Customer must enter the booking ID which is associated with their name
 * 		4.5.3-REQ-3: The cancellation can only go through if the time of cancellation is before the booking expiry time
 */
public class Cancelbooking {
	
	/* 4.5.3-REQ-2 */
	public void cancelBooking() {
		
	}
	public void bookingIDCheck() {
		
	}
	
	/* 4.5.3-REQ-3 */
	public boolean checkTiming() {
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cancel Booking");
	}

}
