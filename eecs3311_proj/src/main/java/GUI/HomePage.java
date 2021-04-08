package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CustomerOperationsModel.Booking;

public class HomePage extends JFrame {
	
	private JPanel contentPane;
	private JLabel thisLabel;
	private JLabel selectParkingSpot;
	private JTextField timeSlotinput;
	private JLabel slabel;
	private JButton bookButton;
	private JButton payButton;
	private JButton viewBookingButton;
	private JTextField parkingspotinput;
	private JLabel lblLicensePlate;
	private JTextField licenceinput;
	private JComboBox lst;
	private JLabel locationCode;
	private JTextField durationInput;
	private String dateOut;
	private String selLoc;
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
		cityLabel.setBounds(10, 52, 170, 25);
		contentPane.add(cityLabel);
		
		// choose location
		JLabel location = new JLabel();
		location.setText("Choose Location: ");
		location.setBounds(10, 70, 170, 25);
		contentPane.add(location);
		
		// location options [https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html]
		//later -> implement this option button fully 
		String[] locOptions = {"Downtown", "Yorkdale", "Square one", "York University", "St George"};
		lst = new JComboBox(locOptions);
//		lst.setSelectedIndex(4);
//		lst.addActionListener(this);
		lst.setBounds(120, 71, 170, 25);
		contentPane.add(lst);
		
		
		/* view of all the available spot of the choosen location */
		//available slot
		JLabel tag1 = new JLabel();
		int count = 0;
		tag1.setText("Available Slots: " + count);
		tag1.setBounds(10, 101, 170, 25);
		contentPane.add(tag1);
		
		/* get the code of the location and check if the parking slots is empty */
		selectParkingSpot = new JLabel();
		selectParkingSpot.setText("Check Spot: ");
		selectParkingSpot.setBounds(10, 138, 80, 25);
		contentPane.add(selectParkingSpot);
		
		// get the selected locations code
		lst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selLoc = lst.getSelectedItem().toString();
				System.out.println(selLoc);

				if (selLoc.equals("Downtown")) {
					locationCode.setText("dt");
				} else if (selLoc.equals("Yorkdale")) {
					locationCode.setText("ydl");
				} else if (selLoc.equals("Square one")) {
					locationCode.setText("sqo");
				} else if (selLoc.equals("York University")) {
					locationCode.setText("york");
				} else if (selLoc.equals("St George")) {
					locationCode.setText("stg");
				} else {}
			}
		});
		
		locationCode = new JLabel();
//		locationCode.setText();
		locationCode.setBounds(120, 138, 73, 25);
		contentPane.add(locationCode);
		
		// parking spot input
		parkingspotinput = new JTextField(20);
		parkingspotinput.setBounds(149, 137, 126, 25);
		contentPane.add(parkingspotinput);
		
		// after clicking this button the system will check if parkingspot is taken or not, by checking booking.csv index4
		JButton selectparkingspotbtn = new JButton("Check Spot");
		selectparkingspotbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pks = parkingspotinput.getText();
				
				Booking kp = new Booking();
				System.out.println(pks);
				if (!kp.checkParkingSpace(pks)) {
					slabel.setText("This spot is free");
				} else {
					slabel.setText("This spot is occupied Please try another spot");
				}
			}
		});
		selectparkingspotbtn.setBounds(270, 137, 100, 25);
		contentPane.add(selectparkingspotbtn);
		
		
		// available time slot
		JLabel timeSlot = new JLabel();
		timeSlot.setText("Start Time:");
		timeSlot.setBounds(10, 190, 170, 25);
		contentPane.add(timeSlot);
		
		// timeSlot input
		timeSlotinput = new JTextField(20);					// max length of input char = 20
//		HintTextField textfield = new HintTextField("Enter your hint");   // later -> add a placeholder text in this input 
		timeSlotinput.setBounds(120,189,100,25);				
		contentPane.add(timeSlotinput);
		
		// duration label 
		JLabel durationLabel = new JLabel();
		durationLabel.setText("Duration (Hrs):");
		durationLabel.setBounds(273, 190, 170, 25);
		contentPane.add(durationLabel);
		
		durationInput = new JTextField(20);
		durationInput.setBounds(375, 189, 109, 25);
		contentPane.add(durationInput);
		
		// get the current date
		DateFormat dt = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		dateOut = dt.format(date);
		System.out.println(dateOut);
		
		JButton startTimeButton = new JButton("T");
		startTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeSlotinput.setText(dateOut);
			}
		});
		startTimeButton.setBounds(220, 189, 45, 25);
		contentPane.add(startTimeButton);
		
	
//		JLabel tag2 = new JLabel("hours");   useless delete later 
//		tag2.setBounds(270,150,170,25);
//		contentPane.add(tag2);
		
//		String[] timeArr = {"Hrs", "Min"};
//		JComboBox tag2 = new JComboBox(timeArr);
//		tag2.setSelectedIndex(1);
//		tag2.setBounds(480,191,80,25);
//		contentPane.add(tag2);
		
		// this button will dump spot number time slot and licsence plate# to booking.csv
		bookButton = new JButton("Reserve Spot ");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spotName = parkingspotinput.getText();
				String startTime = timeSlotinput.getText();
				String duration = durationInput.getText();
				String licensePlate = licenceinput.getText();
				
				// dump the data to booking.csv
				
				
				
				
				System.out.println(spotName);
				System.out.println(startTime);
				System.out.println(duration);
				System.out.println(licensePlate);
			}	    	
	     });
		bookButton.setBounds(73,252,370,25);
	    contentPane.add(bookButton);
		
	    slabel = new JLabel();
	    slabel.setBounds(101,328,411,25);
	    contentPane.add(slabel);
	    
	    // pay button  [later add action listener]
		payButton = new JButton("Pay");
		payButton.setBounds(73, 279, 370, 25);
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
		viewBookingButton.setBounds(73, 304, 370, 25);
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
		
		lblLicensePlate = new JLabel();
		lblLicensePlate.setText("License Plate#:");
		lblLicensePlate.setBounds(10, 220, 170, 25);
		contentPane.add(lblLicensePlate);
		
		// license plate input
		licenceinput = new JTextField(20);
		licenceinput.setBounds(120, 220, 170, 25);
		contentPane.add(licenceinput);
		
		JLabel lblchooseAnyNumber = new JLabel();
		lblchooseAnyNumber.setText("(Choose any number between 1-50)");
		lblchooseAnyNumber.setBounds(120, 162, 293, 25);
		contentPane.add(lblchooseAnyNumber);
		
	}
	
	// price calculator per min [move it to the backend class later]
	// time in min
	private static String priceTag(double time) {
//		String time = timeSlotinput.getText();
//		double doubleTime = Double.parseDouble(time);
		
		// set the time limit for parkinghere [assumtion: customer can book anytime between 0 to 24hrs]
		// this one is for hours; later -> make the same arrangement for miniutes when cs chooses minitues
//		if (doubleTime > 0.0 && doubleTime < 24.0) {
//			System.out.println(doubleTime);
//			timeAdded.setText("Time added successfully");
//		} else {
//			timeAdded.setText("Invalid timing!! Please put time between 0 to 24 hrs");
//		}
		
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
