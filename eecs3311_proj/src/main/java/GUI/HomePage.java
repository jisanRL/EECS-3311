package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {
	
	private static JPanel contentPane;
	private static JLabel thisLabel;

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
		
		
		// table view of all the available spot of the choosen location
		
		
	}
	

}
