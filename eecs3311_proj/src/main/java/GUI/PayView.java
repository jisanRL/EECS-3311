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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	private JTextField textField;
	private JButton selectparkingspotbtn;
	private JLabel lblCreditCard;
	private JTextField textField_1;
	private JLabel lblPayementSuccessful;
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
		payButton.setBounds(89, 159, 370, 25);
		contentPane.add(payButton);
		
		JLabel price_1 = new JLabel();
		price_1.setText("Price:  $time * 0.5");
		price_1.setBounds(51, 52, 170, 25);
		contentPane.add(price_1);
		
		selectParkingSpot_1 = new JLabel();
		selectParkingSpot_1.setText("Select Spot: ");
		selectParkingSpot_1.setBounds(19, 89, 170, 25);
		contentPane.add(selectParkingSpot_1);
		
		textField = new JTextField(20);
		textField.setBounds(100, 88, 170, 25);
		contentPane.add(textField);
		
		selectparkingspotbtn = new JButton("Select Spot");
		selectparkingspotbtn.setBounds(271, 88, 100, 25);
		contentPane.add(selectparkingspotbtn);
		
		lblCreditCard = new JLabel();
		lblCreditCard.setText("Credit Card#:");
		lblCreditCard.setBounds(19, 122, 170, 25);
		contentPane.add(lblCreditCard);
		
		textField_1 = new JTextField(20);
		textField_1.setBounds(100, 121, 170, 25);
		contentPane.add(textField_1);
		
		lblPayementSuccessful = new JLabel("Payement Successful");
		lblPayementSuccessful.setBounds(99, 196, 411, 25);
		contentPane.add(lblPayementSuccessful);
		
		// more functions to be added later
		// add payment format
	}
}
