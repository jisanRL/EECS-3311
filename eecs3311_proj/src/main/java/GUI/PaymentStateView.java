package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import AdminOperationsModel.PaymentStatus;
import CustomerOperationsModel.ViewBooking;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	private JList list;
	
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
		thisLabel.setBounds(168, 6, 200, 25);   // set the position of the component
		contentPane.add(thisLabel); 			// add to the content
		
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
		
		paymentconfirmedMessage = new JLabel();
		paymentconfirmedMessage.setBounds(156,329,200,25);
	    contentPane.add(paymentconfirmedMessage);

        
	    // update customer payment section  
	    paymentreceivedMessage = new JLabel();
	    paymentreceivedMessage.setBounds(18,39,300,25);
	    double amount = 0.0;
//	    paymentreceivedMessage.setText("Payment Amount received:  $" + amount);
	    contentPane.add(paymentreceivedMessage);
	    
	    // clicking this button will dump the username, email and parkingspace# to the adminbooking.csv where all the booking records are kept
	    JButton btnNewButton = new JButton("Paid");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		PaymentStatus ps = new PaymentStatus();
	    		String name = nameInput.getText();
	    		String email = emailInput.getText();
	    		String pspot  = psnInput.getText();
	    		
	    		try {
					ps.confirmPayment(name, email, pspot);
					paymentconfirmedMessage.setText("Payment Confirmed");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnNewButton.setBounds(117, 300, 200, 29);
	    contentPane.add(btnNewButton);  
	    
	    ArrayList<String> mx = new ArrayList<String>();
	    PaymentStatus ps = new PaymentStatus();
//		mx.addAll();
	    list = new JList(ps.viewBooking().toArray());
	    list.setBounds(28, 62, 499, 131);
	    contentPane.add(list);
	    
	    String col[] = {"USERNAME","BOOKINGID","DATE","BOOKING TIME","DURATION" ,"BOOKING SPOT","PRICE","PAYMENT STATUS" , "LICENSE NUMBER"};
	    String data[][] = {{},{}};
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(28, 62, 499, 131);
	    scrollPane.setViewportView(list);
	    list.setLayoutOrientation(JList.VERTICAL);
	    contentPane.add(scrollPane);
	}
}
