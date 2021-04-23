package Interfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * Deals with all the CSV operations 
 */
public interface CSVOps {
	
	public void writeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password) throws IOException;
	
	public void removeUser(String name,
			String userType,String email,String userName,String phoneNumber,
			String address,String password);
	
	public void bookparkingSpace(String userName, 
		       String bookingID, String date, String time, 
		       String duration,String spotName, String price, 
		       String paymentStat, String licenceNum, 
		       String paymentType);
	
	public void cancelBooking(String userName, String bookingID, String date, String time, 
			String duration,String spotName, String price, String paymentStat, String licenceNum);
	
	
}
