package main;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.App.InputHandler;




public class GUI {

/**
   This program shows a frame that is filled with two components.
*/
	
	//class fields ONLY NEEDS ONE WINDOW/JFRAME
	JFrame window;
	
	//Welcome Panel, USE PANELS WHEN YOUR WANT TO CREATE NEW PAGES (NOT ENTIRE JFrames)
	JPanel welcomePanel;
	JButton clientButton;
	JButton ownerButton;
	JLabel clientUser;
	JLabel login;
	
	//Client Panel
	JPanel clientPanel;
	JTextField clientIDField;
	//add more components
	JButton clientSubmit;
	
	//Owner Panel
	JPanel ownerPanel;
	JTextField ownerIDField;
	//add more components
	JButton ownerSubmit;
	
	public void createGUI(InputHandler iHandler) {  
		  
		//initialize everything
	      window = new JFrame();
	      login = new JLabel("  Logging into to Cloud System!");
	      clientUser = new JLabel("                    Are you a Client or a User?                   ");

	      ownerButton = new JButton("Owner");
	      ownerButton.addActionListener(iHandler);
	      ownerButton.setActionCommand("owner");
	      
	      clientButton = new JButton("Client");
	      clientButton.addActionListener(iHandler);
	      clientButton.setActionCommand("client");
	      
	      welcomePanel = new JPanel();
	      welcomePanel.add(login);
	      welcomePanel.add(clientUser);
	      welcomePanel.add(ownerButton);
	      welcomePanel.add(clientButton);
	      
	      //add welcome panel
	      window.add(welcomePanel);

	     
	      
	     //------------------------------------ Client Action Panel
	      clientPanel = new JPanel();
	    //set panel's layout to border layout
	      clientPanel.setLayout(new BorderLayout());
	      clientIDField = new JTextField();
	      clientSubmit = new JButton("Submit");
	      
	      
	      //add components to clientPanel
	      clientPanel.add(clientIDField, BorderLayout.NORTH);
	      clientPanel.add(clientSubmit, BorderLayout.SOUTH);
	      
	      
	     //------------------------------------ Owner Action Panel
	     ownerPanel = new JPanel();
	   //set panel's layout to border layout
	      ownerPanel.setLayout(new BorderLayout());
	     ownerIDField = new JTextField();
	     ownerSubmit = new JButton("Submit");
	     
	     
	     //add components to ownerPanel
	     ownerPanel.add(ownerIDField, BorderLayout.NORTH);
	     ownerPanel.add(ownerSubmit, BorderLayout.SOUTH);
	     
	     
	     //THIS NEEDS TO BE AT THE BOTTOM
	     final int FRAME_WIDTH = 800;
	      final int FRAME_HEIGHT = 600;
	      window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      window.setTitle("The Matrix");
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      window.setLocationRelativeTo(null);

	      window.setVisible(true);

	}
	
}
