package RegistrationLoginModel;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoginTest {
	
	Login login;
	
	@Test
	public void test() {
		login = new Login();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	public void authenticate() {
		String userName = ""; 
		String password = "";
		
		if (userName == null || password == null) {
			expectedEx.expectMessage("Null");
		} else {
			login.authenticate(userName, password);
			expectedEx.expectMessage("Success");
		}
	}
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	public void checkUserType() {
		String userName = ""; 
		String password = "";
		
		if (userName == null || password == null) {
			expectedEx2.expectMessage("Null");
		} else {
			login.checkUserType(userName, password);
			expectedEx2.expectMessage("Success");
		}
	}

}
