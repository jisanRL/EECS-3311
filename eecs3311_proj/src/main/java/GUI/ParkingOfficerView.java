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
		int count = 50;									// later fix the number make it realtime
		parkingSpaceCount.setText("Total Number of Parking Spaces: " + count);
		parkingSpaceCount.setBounds(10, 100, 500, 25);
		contentPane.add(parkingSpaceCount);
		
		availableparkingSpaceCount = new JLabel();
		int availableCount = 0;									// later fix the number make it realtime
		availableparkingSpaceCount.setText("Total Number of Available Parking Spaces: " + availableCount);
		availableparkingSpaceCount.setBounds(10, 130, 500, 25);
		contentPane.add(availableparkingSpaceCount);
		
		
		// buttons
		// add parking space
		addLabel = new JLabel();
		addLabel.setText("Add Parking Space: ");
		addLabel.setBounds(10, 200, 500, 25);
		contentPane.add(addLabel);
		
		// add button
		addButton = new JButton("+ Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		addButton.setBounds(260, 200, 90, 25);
		contentPane.add(addButton);

		// Remove parking space
		removeLabel = new JLabel();
		removeLabel.setText("Remove Parking space: ");
		removeLabel.setBounds(10, 230, 500, 25);
		contentPane.add(removeLabel);

		// remove button
		removeButton = new JButton("- Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		removeButton.setBounds(260, 230, 90, 25);
		contentPane.add(removeButton);
		
		//addRemoveMessage [later fix the add remove message]
	    addRemoveMessage = new JLabel("dscsdcsdc");
	    addRemoveMessage.setBounds(250,260,200,25);
	    contentPane.add(addRemoveMessage);
			    
	}

}
