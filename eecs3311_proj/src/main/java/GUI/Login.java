package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	private static JLabel userlabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	
	
	public static void main(String[] args) {
		
		JFrame fm = new JFrame("Parking");				// title of the application
		fm.setSize(350, 200);						    // set the width and height of the frame
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel();
		fm.add(jp);
		
		placeComponents(jp);
		fm.setVisible(true);
	}
	
	// fix this / refurbish this  
	private static void placeComponents(JPanel panel) {

        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("User");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left 
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 120, 25);
        panel.add(loginButton);
        
     // Creating register button
        JButton rButton = new JButton("register");
        rButton.setBounds(140, 80, 120, 25);
        panel.add(rButton);
    }


}
