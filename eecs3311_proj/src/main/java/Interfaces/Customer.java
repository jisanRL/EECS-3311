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
 * for the customer
 */
public interface Customer {
	
	public boolean checkParkingSpace(String spotName);
	
	public void bookparkingSpace(String userName, String bookingID, String date, String time, 
			String duration,String spotName, String price, String paymentStat, String licenceNum) throws IOException;
	
	public int userCount(String userName) throws FileNotFoundException;
	
	public String bookingID(); 
}
