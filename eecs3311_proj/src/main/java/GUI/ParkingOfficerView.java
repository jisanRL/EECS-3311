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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import PEOoperationsModel.PEO;

import javax.swing.JTextField;

public class ParkingOfficerView extends JFrame{
	
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel parkingSpaceCount;
	private JLabel availableparkingSpaceCount;
	private JButton addButton;
	private JButton removeButton;
	private JLabel addLabel;
	private JLabel removeLabel;
	private JLabel addRemoveMessage;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		System.out.println("This is the Parking Officer pane");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingOfficerView peo = new ParkingOfficerView();
					peo.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	public ParkingOfficerView() {
		setTitle("PEO page");
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
		thisLabel.setBounds(140, 15, 170, 25); // set the position of the component
		contentPane.add(thisLabel);
		
		
		JLabel tag1 = new JLabel("Select Location: ");
		tag1.setBounds(10, 60, 500, 25);
		contentPane.add(tag1);
		
		// location options
		// [https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html]
		// later -> implement this option button fully
		String[] locOptions = { "Downtown", "Yorkdale", "Square one", "York University", "St George" };
		JComboBox lst = new JComboBox(locOptions);
		lst.setSelectedIndex(4);
//		lst.addActionListener(this);
		lst.setBounds(120, 60, 170, 25);
		contentPane.add(lst);
		
		// later -> this part will be connected in the backend with the customer's part where they see the number of available spaces 
		parkingSpaceCount = new JLabel();
		int count = 1500;									// later fix the number make it realtime
		parkingSpaceCount.setText("Total Number of Parking Spaces per location: " + count);
		parkingSpaceCount.setBounds(10, 100, 500, 25);
		contentPane.add(parkingSpaceCount);
		
		availableparkingSpaceCount = new JLabel();
		PEO p = new PEO();
		int availableCount = p.countParkingSpace();									// later fix the number make it realtime
		availableparkingSpaceCount.setText("Total Number of Available Parking Spaces: " + availableCount);
		availableparkingSpaceCount.setBounds(10, 130, 500, 25);
		contentPane.add(availableparkingSpaceCount);
		
		
		// buttons
		// add parking space
		addLabel = new JLabel();
		addLabel.setText("Add Parking Space: ");
		addLabel.setBounds(19, 178, 500, 25);
		contentPane.add(addLabel);
		
		// add button
		addButton = new JButton("+ Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String spotName = textField.getText();
				try {
					PEO peo = new PEO();
					peo.addSpaces(spotName);
				    addRemoveMessage.setText("Successfully Added Parking Space");					//
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		addButton.setBounds(348, 179, 90, 25);
		contentPane.add(addButton);

		// Remove parking space
		removeLabel = new JLabel();
		removeLabel.setText("Remove Parking space: ");
		removeLabel.setBounds(20, 214, 500, 25);
		contentPane.add(removeLabel);

		// remove button
		removeButton = new JButton("- Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String spotName = textField.getText();
				try {
					PEO peo = new PEO();
					peo.removeSpaces(spotName);
				    addRemoveMessage.setText("Successfully Removed Parking Space");					//
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		removeButton.setBounds(349, 214, 90, 25);
		contentPane.add(removeButton);
		
		//addRemoveMessage [later fix the add remove message]
	    addRemoveMessage = new JLabel("");  					//Successfully Added/Removed  Parking Space
	    addRemoveMessage.setBounds(178,251,303,25);
	    contentPane.add(addRemoveMessage);
			    
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
		
		// parking spot number 
		textField = new JTextField();
		textField.setBounds(178, 178, 170, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(178, 211, 170, 26);
		contentPane.add(textField_1);
	}
}