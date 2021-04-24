package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import AdminOperationsModel.Admin;
import RegistrationLoginModel.Register;

public class AdminView extends JFrame {
	
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel PEOCount;
	private JButton addButton;
	private JButton removeButton;
	private JLabel addRemoveMessage;
	private JButton confirmPaymentButton;
	private static JLabel userlabel;
	private static JLabel usertype;
	private static JLabel passwordLabel;
	private static JLabel success;
	private static JLabel name;
	private static JLabel email;
	private static JLabel address;
	private static JLabel phone;
	private static JTextField nameInput;
	private static JTextField emailInput;
	private static JTextField addressInput;
	private static JTextField phoneInput;
	private static JTextField userText;
	private static JPasswordField passwordText;
	

	/*
	 * REQ-4.1 & 4.9: Admin GUI
	 */
	public static void main(String[] args) {
		System.out.println("This is the Admin pane");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView admn = new AdminView();
					admn.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminView() {
		setTitle("System Administrator");
		// create the panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400); 							// x y len wid
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(192, 192, 192)); 	// background color of the app -> Silver
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// title
		thisLabel = new JLabel("instaParking"); 				// Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(140, 15, 170, 25); 					// set the position of the component
		contentPane.add(thisLabel); 							// add to the content
		
		PEOCount = new JLabel();
		int count = 0;			// later fix the number make it realtime
//		PEOCount.setText("Number of Parking Enforcement Officer: " + count);
		PEOCount.setBounds(10, 292, 500, 25);
		contentPane.add(PEOCount);
		
		// name
		name = new JLabel("Name: ");
		name.setBounds(10, 50, 80, 25);
		contentPane.add(name);

		// user input
		nameInput = new JTextField(20); // max length of input char = 20
		nameInput.setBounds(120, 50, 165, 25);
		contentPane.add(nameInput);

		// email
		email = new JLabel("Email: ");
		email.setBounds(10, 75, 80, 25);
		contentPane.add(email);

		// email input
		emailInput = new JTextField(20); // max length of input char = 20
		emailInput.setBounds(120, 75, 165, 25);
		contentPane.add(emailInput);

		// phone
		phone = new JLabel("Phone Number: ");
		phone.setBounds(10, 100, 100, 25);
		contentPane.add(phone);

		// phone input
		phoneInput = new JTextField(20); // max length of input char = 20
		phoneInput.setBounds(120, 100, 165, 25);
		contentPane.add(phoneInput);

		// address
		address = new JLabel("Address: ");
		address.setBounds(10, 125, 80, 25);
		contentPane.add(address);

		// Address input
		addressInput = new JTextField(20); // max length of input char = 20
		addressInput.setBounds(120, 125, 165, 25);
		contentPane.add(addressInput);

		// username part
		userlabel = new JLabel("User Name: ");
		userlabel.setBounds(10, 150, 80, 25);
		contentPane.add(userlabel);

		// username input
		userText = new JTextField(20); // max length of input char = 20
		userText.setBounds(120, 150, 165, 25);
		contentPane.add(userText);

		// usertype part
		usertype = new JLabel("User Type: ");
		usertype.setBounds(10, 175, 80, 25);
		contentPane.add(usertype);

		String[] userOptions = {"parking officer"};
		final JComboBox lst = new JComboBox(userOptions);
		lst.setSelectedIndex(0);
//				lst.addActionListener(this);
		lst.setBounds(120, 175, 170, 25);
		contentPane.add(lst);

		// password part
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 200, 80, 25);
		contentPane.add(passwordLabel);

		// password input
		passwordText = new JPasswordField(20); // max length of input char = 20
		passwordText.setBounds(120, 200, 165, 25);
		contentPane.add(passwordText);

		// adds PEO to database.csv
		// add button, takes to the registration page,
		addButton = new JButton("+ Add PEO");
		// write the user input to the database.csv
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the data [later make sure inputs are regular expressions no numbers or random input]
				String name = nameInput.getText();
				String email = emailInput.getText();
				String phoneNumber = phoneInput.getText();
				String address = addressInput.getText();
				String userName = userText.getText();
				String userType = (String) lst.getSelectedItem();
				String password = passwordText.getText();
				Admin adm = new Admin();
				
				// write into database.csv by calling writeUser method
				if (name==null || email == null || phoneNumber== null || 
						address == null || userName == null || userType == null || 
						password.isEmpty()) {
					addRemoveMessage.setText("Please leave no field empty");
					throw new RuntimeException();
				} else {
					try {
						adm.writeUser(name, userType, email, userName, phoneNumber, address, password);
						addRemoveMessage.setText("PEO successfully Added");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println(name);
				System.out.println(userType);
				System.out.println(email);
				System.out.println(userName);
				System.out.println(phoneNumber);
				System.out.println(address);
				System.out.println(password);
			}
		});
		addButton.setBounds(43, 226, 190, 25);
		contentPane.add(addButton);

		// remove button
		removeButton = new JButton("- Remove PEO");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the data
				String name = nameInput.getText();
				String email = emailInput.getText();
				String phoneNumber = phoneInput.getText();
				String address = addressInput.getText();
				String userName = userText.getText();
				String userType = (String) lst.getSelectedItem();
				String password = passwordText.getText();
				Admin adm = new Admin();
				
				// write into database.csv by calling writeUser method
				if (name==null || email == null || phoneNumber== null || address == null || userName == null || userType == null || password.isEmpty()) {
					addRemoveMessage.setText("Please leave no field empty");
					throw new RuntimeException();
				} else {
					adm.removeUser(name, userType, email, userName, phoneNumber, address, password);
					addRemoveMessage.setText("PEO successfully Removed");
					
				}
				System.out.println(name);
				System.out.println(userType);
				System.out.println(email);
				System.out.println(userName);
				System.out.println(phoneNumber);
				System.out.println(address);
				System.out.println(password);

			}
		});
		removeButton.setBounds(222, 226, 190, 25);
		contentPane.add(removeButton);

		// addRemoveMessage
		addRemoveMessage = new JLabel("");
		addRemoveMessage.setBounds(101, 255, 269, 25);
		contentPane.add(addRemoveMessage);
		
		confirmPaymentButton = new JButton("Change Payment Status");
		confirmPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PaymentStateView psv = new PaymentStateView();
				psv.setVisible(true);
			}
		});
		confirmPaymentButton.setBounds(354,51,190,25);
	    contentPane.add(confirmPaymentButton);
	    
	    JButton logout = new JButton("Logout");
		logout.setBounds(444, 15, 100, 25);
		logout.addActionListener(new ActionListener() {
			// takes to loginView
			public void actionPerformed(ActionEvent e) {
				LoginView lv = new LoginView();
				lv.setVisible(true);
			}
		});
		contentPane.add(logout);
	}
}
