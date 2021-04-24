package RegistrationLoginModel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RegisterTest {
	
	Register register;
	private static String userPath = "../eecs3311_proj/CSVs/database.csv";

	@Test
	public void test() {
		register = new Register();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	public void writeUser() throws IOException {
		String name = "";
		String userType = "";
		String email = "";
		String userName = "";
		String phoneNumber = "";
		String address = "";
		String password="";
		
		if ( name == null || userType == null || email == null || userName == null || phoneNumber == null || address == null || password == null) {
			expectedEx2.expectMessage("Null");
		} else {
			register.writeUser(name,userType, email,userName,phoneNumber,address,password);
			expectedEx2.expectMessage("Not Null");
		}
	}
}
