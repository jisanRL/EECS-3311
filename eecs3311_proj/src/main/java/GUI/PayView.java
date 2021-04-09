package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CustomerOperationsModel.Payment;

public class PayView extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel selectParkingSpot;
	private JTextField timeSlotinput;
	private JLabel timeAdded;
	private JButton timeSlotButton;
	private JLabel price;
	private JButton backButton;
	private JButton bookButton;
	private JButton payButton;
	private JButton viewBookingButton;
	private JLabel selectParkingSpot_1;
	private JTextField spotName;
	private JButton selectparkingspotbtn;
	private JLabel lblCreditCard;
	private JTextField creditCard;
	private JLabel lblPayementSuccessful;
	HomePage hp = new HomePage();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("This is the pay pane");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayView pv = new PayView();
					pv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayView() {
		setTitle("Payment Page");
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
		thisLabel = new JLabel("instaParking"); // Logo
		thisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thisLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		thisLabel.setBackground(Color.WHITE);
		thisLabel.setBounds(140, 15, 170, 25); 	// set the position of the component
		contentPane.add(thisLabel); 			// add to the content
	
		// back button takes back to homePage
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		backButton.setBounds(439, 17, 86, 25);
		contentPane.add(backButton);
		
		// pay button  [later add action listener]
		payButton = new JButton("Pay");
		payButton.setBounds(98, 159, 361, 25);
		contentPane.add(payButton);
		
		JLabel price_1 = new JLabel();
		price_1.setText("Price: ");
		price_1.setBounds(66, 75, 170, 25);
		contentPane.add(price_1);
		
		
		String prc = hp.prc;
		JLabel price = new JLabel();
		price.setText(prc);
		price.setBounds(110, 75, 170, 25);
		contentPane.add(price);
		
//		selectParkingSpot_1 = new JLabel();
//		selectParkingSpot_1.setText("Selected Spot: ");
//		selectParkingSpot_1.setBounds(19, 89, 170, 25);
//		contentPane.add(selectParkingSpot_1);
//		
//		spotName = new JTextField(20);
//		spotName.setBounds(110, 89, 170, 25);
//		contentPane.add(spotName);
		
//		selectparkingspotbtn = new JButton("Select Spot");
//		selectparkingspotbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				HomePage hp = new HomePage();
//				spotName.setText(hp.spotName);
//			}
//		});
//		selectparkingspotbtn.setBounds(279, 90, 100, 25);
//		contentPane.add(selectparkingspotbtn);
		
		lblCreditCard = new JLabel();
		lblCreditCard.setText("Credit Card#:");
		lblCreditCard.setBounds(19, 122, 170, 25);
		contentPane.add(lblCreditCard);
		
		String[] payOptions = {"pay options..", "Credit card", "paypal", "Debit card"};
		JComboBox lst = new JComboBox(payOptions);
//		lst.setSelectedIndex(4);
//		lst.addActionListener(this);
		lst.setBounds(279, 128, 126, 25);
		contentPane.add(lst);
		
		creditCard = new JTextField(20);
		creditCard.setBounds(110, 126, 170, 25);
		contentPane.add(creditCard);
		
		lblPayementSuccessful = new JLabel("Payement Successful");
		lblPayementSuccessful.setBounds(99, 196, 411, 25);
		contentPane.add(lblPayementSuccessful);
		
		// more functions to be added later
		// add payment format
	}
}
