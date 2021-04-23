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

import RegistrationLoginModel.Login;



public class LoginView extends JFrame {
	
	private static JLabel userlabel;
	private static JLabel passwordLabel;
	private static JLabel slabel;
	private static JLabel thisLabel;
	private static JPanel contentPane;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JButton registerButton;
	static String user;
	String pswd;
	
	/*
	 * Launches the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frm = new LoginView();
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
	public LoginView() {
		setTitle("Login");
		// create the panel 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);		// x y len wid
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0,0,0));
		contentPane.setBackground(new Color(192,192,192));		// background color of the app -> Silver 
		contentPane.setBorder(new EmptyBorder(6,6,6,6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//title
		thisLabel = new JLabel("instaParking");			// Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(100, 15, 170, 25);			// set the position of the component 
		contentPane.add(thisLabel);						// add to the content 
		
		// username part
		userlabel = new JLabel("User Name: ");
		userlabel.setBounds(10,40,80,25);
		contentPane.add(userlabel);
		
		// user input 
		userText = new JTextField(20);					// max length of input char = 20
		userText.setBounds(100,40,165,25);				
		contentPane.add(userText);

	     // password part
	     passwordLabel = new JLabel("Password");
	     passwordLabel.setBounds(10,70,80,25);
	     contentPane.add(passwordLabel);
		
		// password input 
	     passwordText = new JPasswordField(20);			// max length of input char = 20
	     passwordText.setBounds(100,70,165,25);
	     contentPane.add(passwordText);
	     
	     // Creating login button
	     loginButton = new JButton("Login");
	     // actionListener to authenticate the user 
	     loginButton.addActionListener(new ActionListener() {
	    	 // authentication
			public void actionPerformed(ActionEvent e) {
				try {
					user = userText.getText();
					pswd = passwordText.getText();
				
					// later -> add exceptions for null input or in valid input
					Login login = new Login();
					login.authenticate(user, pswd); 
					
					if(user == null || pswd.isEmpty()){
				        slabel.setText("Please leave no field empty");
						throw new RuntimeException();
				    }
					if (login.authenticate(user, pswd) == false) {
						slabel.setText("User Not found");
					}
					
					// set the path
					if (login.checkUserType(user, pswd).equalsIgnoreCase("customer")) {
						HomePage hp = new HomePage();
						hp.setVisible(true);
					} else if(login.checkUserType(user, pswd).equalsIgnoreCase("parking officer")) {
						ParkingOfficerView pv = new ParkingOfficerView();
						pv.setVisible(true);
					} else if(login.checkUserType(user, pswd).equalsIgnoreCase("admin")) {
						AdminView adv = new AdminView();
						adv.setVisible(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}	    	
	     });
	     loginButton.setBounds(10, 100, 120, 25);
	     contentPane.add(loginButton);
	     
	     slabel = new JLabel("");
	     slabel.setBounds(20, 129, 250, 25);
	     contentPane.add(slabel);
	     
	     // register button, takes to the registration page 
	     registerButton = new JButton("register");
	     registerButton.setBounds(140, 100, 120, 25);
	     registerButton.addActionListener(new ActionListener() {
				// goes to the register page
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					RegistrationView reg = new RegistrationView();
					reg.setVisible(true);
				}
			});
	     contentPane.add(registerButton);
	}
}
