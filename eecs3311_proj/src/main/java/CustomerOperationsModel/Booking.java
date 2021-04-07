package CustomerOperationsModel;

/*
 * REQ 4.4 Booking a parking space
 * 		4.4.3-REQ-1: Customer must be registered and logged-in before booking a parking space   [done in REQ 4.2 and 4.3]
 * 		4.4.3-REQ-2: Customer must select which parking space they are booking
 * 		4.4.3-REQ-3: If the customer selects a parking space which is occupied, they are presented with an error message and must select a new space
 * 		4.4.3-REQ-4: Customer must enter how long they want to book said parking space for
 * 		4.4.3-REQ-5: The system allows a customer to book up to three parking spaces  [in a given location;ie.3 space in york at a time]
 * 		4.4.3-REQ-6: Each booked parking space receives a unique booking ID
 * 		4.4.3-REQ-7: The system must display an error message if the parking space the customer booked is occupied in the system
 */
public class Booking {
	
	/* 4.4.3-REQ-2 */
	public void selectParkingSpace() {
		
	}
	
	/* 4.4.3-REQ-3 */
	public String errorMessage() {
		return null;
	}
	
	/*  4.4.3-REQ-4 */
	public int bookingDuration() {
		return 0;
	}
	
	/*
	 * 4.4.3-REQ-5: The system allows a customer to book up to three parking spaces  [in a given location;ie.3 space in york at a time]
	 * 4.4.3-REQ-7: The system must display an error message if the parking space the customer booked is occupied in the system
	 * BOOKING.CSV schema -> USERNAME,BOOKINGID,DATE,DURATION ,BOOKING SPOT,PRICE,PAYMENT STATUS , LICENSE NUMBER
	 */
	public int bookparkingSpace() {
		return 0;
	}
	
	/* 4.4.3-REQ-6  */
	public int bookingNumber() {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Booking Backend");
	}
}
