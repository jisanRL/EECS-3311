package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//refurbish later this if possible
public class Registration extends JFrame {

	private static JLabel userlabel;
	private static JLabel passwordLabel;
	private static JLabel success;
	private static JLabel thisLabel;
	private static JLabel name;
	private static JLabel email;
	private static JLabel address;
	private static JLabel phone;
	private static JTextField nameInput;
	private static JTextField emailInput;
	private static JTextField addressInput;
	private static JTextField phoneInput;
	private static JPanel contentPane;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JButton registerButton;

	public static void main(String[] args) {
		System.out.println("This is the registration pane");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frm = new Registration();
					frm.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * create the frame
	 */
	public Registration() {
		// create the panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400); // x y len wid
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(192, 192, 192)); // background color of the app -> Silver
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// title
		thisLabel = new JLabel("Register!!"); 			// Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(100, 15, 170, 25); // set the position of the component
		contentPane.add(thisLabel); // add to the content
		
		// name
		name = new JLabel("Name: ");
		name.setBounds(10, 50, 80, 25);
		contentPane.add(name);
		
		// user input
		nameInput = new JTextField(20); // max length of input char = 20
		nameInput.setBounds(100, 50, 165, 25);
		contentPane.add(nameInput);
		
		// email
		email = new JLabel("Email: ");
		email.setBounds(10, 75, 80, 25);
		contentPane.add(email);
		
		// email input
		emailInput = new JTextField(20); // max length of input char = 20
		emailInput.setBounds(100, 75, 165, 25);
		contentPane.add(emailInput);
		
		// phone
		phone = new JLabel("Phone Number: ");
		phone.setBounds(10, 100, 80, 25);
		contentPane.add(phone);
		
		// phone input
		phoneInput = new JTextField(20); // max length of input char = 20
		phoneInput.setBounds(100, 100, 165, 25);
		contentPane.add(phoneInput);
		
		// address
		address = new JLabel("Address: ");
		address.setBounds(10, 125, 80, 25);
		contentPane.add(address);
		
		// Address input
		addressInput = new JTextField(20); // max length of input char = 20
		addressInput.setBounds(100, 125, 165, 25);
		contentPane.add(addressInput);
		
		
		// username part
		userlabel = new JLabel("User Name: ");
		userlabel.setBounds(10, 150, 80, 25);
		contentPane.add(userlabel);

		// user input
		userText = new JTextField(20); 					// max length of input char = 20
		userText.setBounds(100, 150, 165, 25);
		contentPane.add(userText);

		// password part
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 175, 80, 25);
		contentPane.add(passwordLabel);

		// password input
		passwordText = new JPasswordField(20);			 // max length of input char = 20
		passwordText.setBounds(100, 175, 165, 25);
		contentPane.add(passwordText);

		// register button, takes to the registration page, 
		// later, enter user information and once that is done put the info in the csv file of user table and 
		registerButton = new JButton("Register");
//		registerButton.setBackground(Color.BLUE);
		registerButton.setBounds(90, 210, 190, 25);
		contentPane.add(registerButton);
		
		
		// Creating login button , Later -> once the success message is given click this button and take to the login page 
		loginButton = new JButton("Login Page");
		loginButton.setBounds(90, 235, 190, 25);
		contentPane.add(loginButton);

		// temporary (later -> upon authentication take from login page to booking space / main dashboard)
		success = new JLabel("");
		success.setBounds(10, 250, 120, 25);
		contentPane.add(success);
	}
}
