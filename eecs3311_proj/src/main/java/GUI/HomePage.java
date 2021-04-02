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

public class HomePage extends JFrame {
	
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel selectParkingSpot;
	private JTextField timeSlotinput;
	private JLabel timeAdded;
	private JButton timeSlotButton;
	private JLabel price;
	
	private JButton bookButton;
	private JButton payButton;
	private JButton viewBookingButton;
	
	/*
	 *REQ-4.4 and 4.5 and 4.6 Booking Space/ Main Dashboard 
	 */
	public static void main(String[] args) {
		System.out.println("This is the HomePage pane");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage hp = new HomePage();
					hp.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	public HomePage() {
		setTitle("Customer HomePage");
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
		
		/*
		 *  booking pane 
		 */
		// city name 
		JLabel cityLabel = new JLabel();
		cityLabel.setText("City: Toronto");
		cityLabel.setBounds(10, 65, 170, 25);
		contentPane.add(cityLabel);
		
		// choose location
		JLabel location = new JLabel();
		location.setText("Choose Location: ");
		location.setBounds(10, 85, 170, 25);
		contentPane.add(location);
		
		// location options [https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html]
		//later -> implement this option button fully 
		String[] locOptions = {"Downtown", "Yorkdale", "Square one", "York University", "St George"};
		JComboBox lst = new JComboBox(locOptions);
		lst.setSelectedIndex(4);
//		lst.addActionListener(this);
		lst.setBounds(120, 85, 170, 25);
		contentPane.add(lst);
		
		
		/* view of all the available spot of the choosen location */
		//available slot
		JLabel tag1 = new JLabel();
		int count = 0;
		tag1.setText("Available Slots: " + count);
		tag1.setBounds(10, 125, 170, 25);
		contentPane.add(tag1);
		
		// select parking slots
		selectParkingSpot = new JLabel();
		selectParkingSpot.setText("Select Spot: ");
		selectParkingSpot.setBounds(10, 160, 170, 25);
		contentPane.add(selectParkingSpot);
		
		// available time slot
		JLabel timeSlot = new JLabel();
		timeSlot.setText("Time Slot: ");
		timeSlot.setBounds(10, 190, 170, 25);
		contentPane.add(timeSlot);
		
		// timeSlot input
		timeSlotinput = new JTextField(20);					// max length of input char = 20
//		HintTextField textfield = new HintTextField("Enter your hint");   // later -> add a placeholder text in this input 
		timeSlotinput.setBounds(100,190,170,25);				
		contentPane.add(timeSlotinput);
		
//		JLabel tag2 = new JLabel("hours");   useless delete later 
//		tag2.setBounds(270,150,170,25);
//		contentPane.add(tag2);
		
		String[] timeArr = {"Hrs", "Min"};
		JComboBox tag2 = new JComboBox(timeArr);
		tag2.setSelectedIndex(1);
		tag2.setBounds(265,192,80,25);
		contentPane.add(tag2);
		
		// time-slot button    [may not be needed]
		timeSlotButton = new JButton("Enter Time");
	    // actionListener to confirm time
		timeSlotButton.addActionListener(new ActionListener() {
	    	 // time slot confimation
			public void actionPerformed(ActionEvent e) {
				String time = timeSlotinput.getText();
				double doubleTime = Double.parseDouble(time);
				
				// set the time limit for parkinghere [assumtion: customer can book anytime between 0 to 24hrs]
				// this one is for hours; later -> make the same arrangement for miniutes when cs chooses minitues
				if (doubleTime > 0.0 && doubleTime < 24.0) {
					System.out.println(doubleTime);
					timeAdded.setText("Time added successfully");
				} else {
					timeAdded.setText("Invalid timing!! Please put time between 0 to 24 hrs");
				}
			}	    	
	     });
		timeSlotButton.setBounds(340,190,100,25);
	    contentPane.add(timeSlotButton);
		
	    timeAdded = new JLabel("");
	    timeAdded.setBounds(100,220,2000,25);
	    contentPane.add(timeAdded);
	    
	    // price 
	    price = new JLabel();
	    price.setText("Price: " + " $time * 0.5");  // fix this later
	    price.setBounds(10, 240, 170, 25);
		contentPane.add(price);
		
		// confirm buttons [later add action listener]
		bookButton = new JButton("Confirm Booking");
		bookButton.setBounds(60, 270, 370, 25);
	    contentPane.add(bookButton);
	    
	    // pay button  [later add action listener]
		payButton = new JButton("Pay");
		payButton.setBounds(60, 297, 370, 25);
		payButton.addActionListener(new ActionListener() {
			// takes to payView
			public void actionPerformed(ActionEvent e) {
				PayView pv = new PayView();
				pv.setVisible(true);
			}
		});
	    contentPane.add(payButton);
	    
	    // view booking button  [later add action listener]
		viewBookingButton = new JButton("View Bookings");
		viewBookingButton.addActionListener(new ActionListener() {
			// takes to reservationView
			public void actionPerformed(ActionEvent e) {
				ReservationView rv = new ReservationView();
				rv.setVisible(true);
			}
		});
		viewBookingButton.setBounds(60, 322, 370, 25);
		contentPane.add(viewBookingButton);
		
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
		
	}
	
	// price calculator per min [move it to the backend class later]
	// time in min
	private static String priceTag(double time) {
		// per min -> $0.5
		double price = 0.0;
		// in terms of min
		if (time > 0 && time < 60) {
			price = time * 0.5;
		} else if (time > 60 && time < 1440) {
			double timehrs = time/60;			// convert min to hrs
			price = timehrs * 30; 				//"calculate in terms of hrs later";
		}
		return "$" + price;
	}
}
