// LoginUI.Java. Creates and handles the logging in of the crypto trading system.
// Written by: Cole Sweet
// Student Number: 251179642

// Imports and package.
package cryptoTrader.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cryptoTrader.utils.DataVisualizationCreator;


/**
 * This creates the Login Window to allow for users to enter username and password pairs to 
 * log into the system. If the pair is not valid, the program terminates. If the pair is valid,
 * an instance of MainUI is created.
 * 
 * This inherits from JFrame for UI and implements ActionListener to get user input.
 *
 * @author Cole Sweet
 */
public class LoginUI extends JFrame implements ActionListener{


	// VARIABLES ========================================
	
	private static LoginUI instance;	// Stores the instance of the LoginUI
	
	private boolean isValidLogin = false;	// Stores if the credentials are valid.
	
	private String username = "";	// Stores the currently entered username.
	private String password = "";	// Stores the currently entered password.
	
	private JTextField usernameTextField;	// Text fields for storing the username.
	private JPasswordField passwordField;	// Password fields for storing the password.

	
	/**
	* This returns the current instance of the LoginUI object.
	* @return LoginUI instance.
	*/
	public static LoginUI getInstance() {
		// If no instance exists, create one using the LoginUI constructor.
		if (instance == null) {
			instance = new LoginUI();
		}

		return instance;	// Return the current instance.
	}
	
	
	/**
	* LoginUI Constructor. Used to create a new LoginUI object.
	*/
	private LoginUI() {

		// Set the Login window's title
		super("Crypto Trading Tool Login Window");

		
		// NORTH PANEL
		// Create a main JPanel to store north UI.
		JPanel north = new JPanel();
		north.setBorder(new EmptyBorder(50,30,0,30));	// Create padding
		this.usernameTextField = new JTextField(8);	// Initialize JTextField for username input.
		this.passwordField = new JPasswordField(8);	// Initialize JPasswordField for password input.
		north.add(usernameTextField); 	// Add text inputs to the north panel.
		north.add(passwordField);

		// SOUTH PANEL
		// Create a main JPanel to store south UI.
		JPanel south = new JPanel();	
		south.setBorder(new EmptyBorder(10,30,30,30));	// Create padding
		JButton login = new JButton("Login");	// Create a login button.
		login.setActionCommand("login");	// Set up code to connect button press to action.
		login.addActionListener(this);
		south.add(login);	// Add button to south panel.
		
		// Add north and south panel to main pane.
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(south, BorderLayout.SOUTH);
	}
	
	
	/**
	* Listens for ActionEvents. 
	* Handles when the user uses the login button.
	* @param ActionEvent e
	* 	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();	// Get the current command from ActionEvent
		
		// If the command was "login" from the Login button, do the following
		if ("login".equals(command)) {

			// Store the username and password in this object.
			this.username = this.usernameTextField.getText();
			this.password = String.valueOf(this.passwordField.getPassword());
			
			// Set the value of isValidLogin based on the inputted username and password.
			this.setValidLogin(checkCredentialValidity(this.username, this.password));
			
			// If the login is valid, do the following.
			if (this.getValidLogin()) {
				JFrame frame = MainUI.getInstance();	// Create MainUI Window
				frame.setSize(900, 600);	// Set MainUI Window Size
				frame.pack();				// Pack MainUI
				frame.setVisible(true);		// Set MainUI to be visible
			} 

			this.dispose();	// Dispose of the LoginUI JPanel. (Close the window)
			
		} else {
			JOptionPane.showMessageDialog(this, "Not a valid action!");
		} 
		
	}
	
	
	/**
	* Checks if the username and password pair entered by the 
	* user is in the valid credentials file.
	* @param String username. The username entered by the user.
	* @param String password. The password entered by the user.
	* 	*/
	private boolean checkCredentialValidity(String username, String password) {
		String cred = username + " " + password;	// Store username and password as a single string.
		
		try {
			// Get access to the file storing valid login credentials.
		    File credentialsFile = new File("credentialData.txt");
		    // Create reader to read file.
		    Scanner fileReader = new Scanner(credentialsFile);
		    
		    // Read each line of the file until the the user-input is found.
		    while (fileReader.hasNextLine()) {
		    	// Read the next line.
		    	String data = fileReader.nextLine();
		    	
		    	// If the next line is equal to the user-input, return true because 
		    	// the user-input was found in the valid credentials file.
		    	if (data.equals(cred)) { return true; }
		    }
		    
		    fileReader.close(); // Close the file reader
		      
		} catch (FileNotFoundException e) {
			System.out.println("Credential Data not found.");
			e.printStackTrace();
		}
		
		// Return false if the username and password combination was not found.
		return false;	
	}

	
	/**
	* Checks if the username and password pair entered by the 
	* user is in the valid credentials file.
	* @return boolean isValidLogin. Returns the validity of the Login information stored in the LoginUI object.
	* 	*/
	public boolean getValidLogin() {
		return isValidLogin;
	}

	
	/**
	* Sets and stores the validity of the login information into the LoginUI object.
	* @param boolean isValidLogin. The username entered by the user.
	*/
	public void setValidLogin(boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
	
	

    
	

}
