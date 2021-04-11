package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CustomerOperationsModel.Cancelbooking;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ReservationView extends JFrame {

	private JPanel contentPane;
	private JLabel thisLabel;
	private JButton backButton;
	private JTextField spotName;
	private JLabel lblBookingCancelled;
	HomePage hp = new HomePage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationView window = new ReservationView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReservationView() {
		setTitle("Reservation Page");
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
		thisLabel = new JLabel("instaParking"); // Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(140, 15, 170, 25); // set the position of the component
		contentPane.add(thisLabel);
		
		//back button takes back to homePage
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		backButton.setBounds(439, 17, 86, 25);
	    contentPane.add(backButton);
	    
	    // later -> customer clicks on a button, a jPane opens up and enters their booking number
	    // removes the entire booking column of the user logged in
	    JButton btnCancellations = new JButton("Cancel Booking");
	    btnCancellations.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String userName = LoginView.user;
	    		String bookginID = hp.bookingID;
	    		String currentDate = hp.startTime;
	    		String currentTime = hp.dateinput;
	    		String duration = hp.duration;
	    		String spot =  spotName.getText();
	    		String price = hp.prc;
	    		String paymentstatus = hp.paymentStat;
	    		String licenseplate = hp.licenseplate;
	    		
	    		if (spotName.getText() == null) {
	    			lblBookingCancelled.setText("Please leave no field empty");
					throw new RuntimeException();
	    		}
	    		Cancelbooking cn = new Cancelbooking();
	    		cn.cancelBooking(userName,bookginID,currentDate,currentTime,duration,spot,price,paymentstatus,licenseplate);
	    	    lblBookingCancelled.setText("Booking cancelled ");
	    	}
	    });
	    btnCancellations.setBounds(125, 256, 199, 25);
	    contentPane.add(btnCancellations);
	    
	    // display all the bookings of the logged in user
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(30, 52, 495, 118);
	    contentPane.add(scrollPane);
	    
	    spotName = new JTextField(20);
	    spotName.setBounds(140, 230, 175, 25);
	    contentPane.add(spotName);
	    
	    JLabel lblParkingSpot = new JLabel();
	    lblParkingSpot.setText("Parking Spot: ");
	    lblParkingSpot.setBounds(25, 231, 114, 25);
	    contentPane.add(lblParkingSpot);
	    
	    lblBookingCancelled = new JLabel();
	    lblBookingCancelled.setBounds(166, 293, 118, 25);
	    contentPane.add(lblBookingCancelled);
		
		// the table -> https://www.geeksforgeeks.org/java-swing-jtable/
		
		
	}
}
