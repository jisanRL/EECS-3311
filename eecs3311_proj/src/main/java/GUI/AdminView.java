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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminView extends JFrame {
	
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel PEOCount;
	private JLabel addLabel;
	private JButton addButton;
	private JButton removeButton;
	private JLabel removeLabel;
	private JLabel addRemoveMessage;
	private JLabel paymentreceivedMessage;
	private JButton confirmPaymentButton;
	private JLabel paymentconfirmedMessage;

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
		PEOCount.setText("Number of Parking Enforcement Officer: " + count);
		PEOCount.setBounds(10, 50, 500, 25);
		contentPane.add(PEOCount);
		
		/* add and remove parking enforcement officer section*/
		// add PEO
		addLabel = new JLabel();
		addLabel.setText("Add Parking Enforcement Officer: ");
		addLabel.setBounds(10, 90, 500, 25);
		contentPane.add(addLabel);
		
		// add button
		addButton = new JButton("+ Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		addButton.setBounds(260, 90, 90, 25);
	    contentPane.add(addButton);
		
		// Remove PEO
		removeLabel = new JLabel();
		removeLabel.setText("Remove Parking Enforcement Officer: ");
		removeLabel.setBounds(10, 120, 500, 25);
		contentPane.add(removeLabel);
		
		// remove button
		removeButton = new JButton("- Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		removeButton.setBounds(260, 120, 90, 25);
	    contentPane.add(removeButton);
	    
	    //addRemoveMessage [later fix the add remove message]
	    addRemoveMessage = new JLabel("dscsdcsdc");
	    addRemoveMessage.setBounds(250,150,200,25);
	    contentPane.add(addRemoveMessage);
		
		// update customer payment section  
	    paymentreceivedMessage = new JLabel();
	    paymentreceivedMessage.setBounds(10,180,300,25);
	    double amount = 0.0;
	    paymentreceivedMessage.setText("Payment Amount received:  $" + amount);
	    contentPane.add(paymentreceivedMessage);
	    
		confirmPaymentButton = new JButton("Confirm Payment");
		confirmPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		confirmPaymentButton.setBounds(10,210,200,25);
	    contentPane.add(confirmPaymentButton);
	    
	    // later -> once confirmPaymentButton is clicked this message will appear, implement this
		paymentconfirmedMessage = new JLabel();
		paymentconfirmedMessage.setBounds(20,240,200,25);
		paymentconfirmedMessage.setText("Payment Confirmed");
	    contentPane.add(paymentconfirmedMessage);
	    
	}
	
}
