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
		payButton.setBounds(60, 297, 370, 25);
		contentPane.add(payButton);
		
		// more functions to be added later
		// add payment format
	}

	

}
