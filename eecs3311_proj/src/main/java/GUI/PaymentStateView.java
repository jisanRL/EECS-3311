package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

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
		thisLabel.setBounds(100, 15, 200, 25); // set the position of the component
		contentPane.add(thisLabel); // add to the content
		
		
		// name
		name = new JLabel("Name: ");
		name.setBounds(30, 126, 80, 25);
		contentPane.add(name);

		// user input
		nameInput = new JTextField(20); // max length of input char = 20
		nameInput.setBounds(135, 125, 165, 25);
		contentPane.add(nameInput);

		// email
		email = new JLabel("Email: ");
		email.setBounds(30, 164, 80, 25);
		contentPane.add(email);

		// email input
		emailInput = new JTextField(20); // max length of input char = 20
		emailInput.setBounds(135, 163, 165, 25);
		contentPane.add(emailInput);

		// phone
		parkingSpacenum = new JLabel("Parking Space#:");
		parkingSpacenum.setBounds(30, 201, 100, 25);
		contentPane.add(parkingSpacenum);
		
		// phone input
		psnInput = new JTextField(20); // max length of input char = 20
		psnInput.setBounds(135, 200, 165, 25);
		contentPane.add(psnInput);
		
		 // later -> move this to the new paymentView GUI once confirmPaymentButton is clicked this message will appear, implement this
		paymentconfirmedMessage = new JLabel();
		paymentconfirmedMessage.setBounds(135,279,200,25);
		paymentconfirmedMessage.setText("Payment Confirmed");
	    contentPane.add(paymentconfirmedMessage);

        
	    // update customer payment section  
	    paymentreceivedMessage = new JLabel();
	    paymentreceivedMessage.setBounds(22,52,300,25);
	    double amount = 0.0;
	    paymentreceivedMessage.setText("Payment Amount received:  $" + amount);
	    contentPane.add(paymentreceivedMessage);
	    
	    JButton btnNewButton = new JButton("Paid");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(122, 238, 200, 29);
	    contentPane.add(btnNewButton);
	    
	    JLabel lblTotalAmount = new JLabel();
	    lblTotalAmount.setText("Total Amount $0.0");
	    lblTotalAmount.setBounds(22, 89, 300, 25);
	    contentPane.add(lblTotalAmount);
	    
		// back button takes back to homePage
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminView av = new AdminView();
				av.setVisible(true);
			}
		});
		backButton.setBounds(439, 17, 86, 25);
		contentPane.add(backButton);
	}
}
