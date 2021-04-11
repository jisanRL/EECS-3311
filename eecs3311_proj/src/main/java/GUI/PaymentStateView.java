package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class PaymentStateView extends JFrame {

	private static JLabel thisLabel;
	private static JPanel contentPane;
	private JLabel paymentreceivedMessage;
	private JLabel paymentconfirmedMessage;
	private static JLabel name;
	private static JLabel email;
	private static JLabel parkingSpacenum;
	private static JTextField nameInput;
	private static JTextField emailInput;
	private static JTextField psnInput;
	private JButton backButton;
	private static String path = "/Users/jisanreza/Documents/3311/eecs3311_proj/CSVs/booking.csv";				// fix this later -> turn to relative path
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentStateView psv = new PaymentStateView();
					psv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentStateView() {
		setTitle("Payment Confirmation ");
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
		thisLabel = new JLabel("instaParking"); 			// Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(168, 6, 200, 25); // set the position of the component
		contentPane.add(thisLabel); // add to the content
		
		// back button takes back to homePage
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminView av = new AdminView();
				av.setVisible(true);
			}
		});
		backButton.setBounds(458, 6, 86, 25);
		contentPane.add(backButton);
		
		// name
		name = new JLabel("Name: ");
		name.setBounds(30, 222, 80, 25);
		contentPane.add(name);

		// user input
		nameInput = new JTextField(20); // max length of input char = 20
		nameInput.setBounds(135, 221, 165, 25);
		contentPane.add(nameInput);

		// email
		email = new JLabel("Email: ");
		email.setBounds(30, 249, 80, 25);
		contentPane.add(email);

		// email input
		emailInput = new JTextField(20); // max length of input char = 20
		emailInput.setBounds(135, 248, 165, 25);
		contentPane.add(emailInput);

		// phone
		parkingSpacenum = new JLabel("Parking Space#:");
		parkingSpacenum.setBounds(30, 276, 100, 25);
		contentPane.add(parkingSpacenum);
		
		// phone input
		psnInput = new JTextField(20); // max length of input char = 20
		psnInput.setBounds(135, 275, 165, 25);
		contentPane.add(psnInput);
		
		 // later -> move this to the new paymentView GUI once confirmPaymentButton is clicked this message will appear, implement this
		paymentconfirmedMessage = new JLabel();
		paymentconfirmedMessage.setBounds(168,341,200,25);
		paymentconfirmedMessage.setText("Payment Confirmed");
	    contentPane.add(paymentconfirmedMessage);

        
	    // update customer payment section  
	    paymentreceivedMessage = new JLabel();
	    paymentreceivedMessage.setBounds(18,39,300,25);
	    double amount = 0.0;
	    paymentreceivedMessage.setText("Payment Amount received:  $" + amount);
	    contentPane.add(paymentreceivedMessage);
	    
	    // clicking this button will dump the username, email and parkingspace# to the adminbooking.csv where all the booking records are kept
	    JButton btnNewButton = new JButton("Paid");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    btnNewButton.setBounds(122, 313, 200, 29);
	    contentPane.add(btnNewButton);
	    
	    JLabel lblTotalAmount = new JLabel();
	    lblTotalAmount.setText("here we will have a table to view entire booking.csv");
	    lblTotalAmount.setBounds(135, 197, 414, 25);
	    contentPane.add(lblTotalAmount);
	  
	    String col[] = {"USERNAME","BOOKINGID","DATE","BOOKING TIME","DURATION" ,"BOOKING SPOT","PRICE","PAYMENT STATUS" , "LICENSE NUMBER"};
	    String data[][] = {{},{}};
	    		
	    // table to display booking.csv
	    table = new JTable(data, data);
	    table.setColumnSelectionAllowed(true);
	    table.setCellSelectionEnabled(true);
	    table.setBounds(30, 186, 465, -122);
	    contentPane.add(table);
	    
	    // clicking this button will display the contents of booking.csv
	    JButton viewBookingbtn = new JButton("Bookings");
	    viewBookingbtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    	}
	    });
	    viewBookingbtn.setBounds(458, 38, 86, 25);
	    contentPane.add(viewBookingbtn);
	}
}
