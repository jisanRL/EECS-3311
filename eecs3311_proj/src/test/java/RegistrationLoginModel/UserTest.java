package RegistrationLoginModel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * test for User class
 * 
 * fix this
 */
public class UserTest {

//	User user = new User("Farhan", "Latif", "farhan95@my.yorku.ca", "4163451214", "112 Arboretum", "farhan95", "user1");

	User user = new User();
	
	@Before
	public void test() throws Exception {
		user.getFirstName();
//		fail("Not yet implemented");
	}
	
	@Rule
	public ExpectedException ems = ExpectedException.none();
	@Test 
	public void setUpFirstName() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems2 = ExpectedException.none();
	@Test 
	public void setUpLastName() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems2.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems3 = ExpectedException.none();
	@Test 
	public void setUpEmail() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems3.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems4 = ExpectedException.none();
	@Test 
	public void setUpPhoneNumber() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems4.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems5 = ExpectedException.none();
	@Test 
	public void setUpAddress() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems5.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems6 = ExpectedException.none();
	@Test 
	public void setUpPhoneNumeber() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems6.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems7 = ExpectedException.none();
	@Test 
	public void setUpUserName() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems7.expectMessage("There is no null value");
	}
	
	@Rule
	public ExpectedException ems8 = ExpectedException.none();
	@Test 
	public void setUpUserType() {
		user.setFirstName("Farhan");
//		user.setFirstName("Jack");
//		user.setFirstName("Richard");
//		user.setFirstName("Ali");
//		user.setFirstName("");
//		user.getFirstName();
		ems8.expectMessage("There is no null value");
	}

}
