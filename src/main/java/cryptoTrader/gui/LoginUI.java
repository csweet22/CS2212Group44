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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cryptoTrader.utils.DataVisualizationCreator;

public class LoginUI extends JFrame implements ActionListener{


	private static LoginUI instance;
	private boolean isValidLogin = false;
	private String username = "";
	private String password = "";
	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	public static LoginUI getInstance() {
		if (instance == null)
			instance = new LoginUI();

		return instance;
	}
	
	// Constructor
	private LoginUI() {

		// Set window title
		super("Crypto Trading Tool Login Window");

		// Set top bar


		JPanel north = new JPanel();
		this.usernameTextField = new JTextField(8);
		this.passwordTextField = new JTextField(8);

		north.add(usernameTextField);
		north.add(passwordTextField);

		JButton login = new JButton("Login");
		login.setActionCommand("login");
		login.addActionListener(this);

		JPanel south = new JPanel();	
		south.add(login);
		
		

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(south, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("login".equals(command)) {

			this.username = this.usernameTextField.getText();
			this.password = this.passwordTextField.getText();
			
			
			this.setValidLogin( checkCredentialValidity(this.username, this.password) );
			
			if (this.isValidLogin()) {
				JFrame frame = MainUI.getInstance();
				frame.setSize(900, 600);
				frame.pack();
				frame.setVisible(true);	
			} 

			this.dispose();
			
		} else {
			JOptionPane.showMessageDialog(this, "Not a valid action!");
		} 
		
	}

	private boolean checkCredentialValidity(String username, String password) {
		String cred = username + " " + password;
		
		try {
		      File credentialsFile = new File("credentialData.txt");
		      Scanner fileReader = new Scanner(credentialsFile);
		      
		      while (fileReader.hasNextLine()) {
		        String data = fileReader.nextLine();
		        
		        if (data.equals(cred)) {
		        	return true;
		        }
		      }
		      
		      fileReader.close();
		      
		    } 
		catch (FileNotFoundException e) {
		      System.out.println("Credential Data not found.");
		      e.printStackTrace();
		    }
		
		return false;
	}

	public boolean isValidLogin() {
		return isValidLogin;
	}

	public void setValidLogin(boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
	
	

    
	

}
