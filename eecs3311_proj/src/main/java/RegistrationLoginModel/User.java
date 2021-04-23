package RegistrationLoginModel;


/*
 * this class defines the user. ie, who/what makes the user the user
 * REQ: User  = customers + parking enforcement officer
 * 
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String userName;
	private String password;
	private boolean userType;
	
	// ctr
	public User() {
		super();
	}
	
	// parameterized ctr
	public User(String firstName, String lastName, String email, 
			String phoneNumber, String address, String userName,String password) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setAddress(address);
		this.setUserName(userName);
		this.setPassword(password);
		this.userType = false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 *  determine the type of the user 
	 *  are they customer or PEO;
	 */
	public boolean userType() {
		String type = "";
		if (type.equalsIgnoreCase("customer")) {
			userType = true;
			System.out.println("User is customer");
		} else if(type.equalsIgnoreCase("user")) {
			userType = true;
			System.out.println("User is PEO");
		} else {}
		return userType;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", userName=" + userName + ", password=" + password + "]";
	}
	
	public static void main(String[] args) {
		User user = new User("Farhan", "Latif", "farhan95@my.yorku.ca", "4163451214", "112 Arboretum", "farhan95", "user1");
		System.out.println(user.toString());
//		System.out.println(user.userType("USER"));
		System.out.println(user.userType());
	}

}
