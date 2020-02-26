package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

//Handles transitions between main screen and profile screen
public class VisibilityManager {

	GUI gui;
	//takes in a GUI object so it can access GUI's fields and methods
	
	public VisibilityManager(GUI userInterface) {
		gui = userInterface;
	}
	
	//switching between panels
	public void showWelcomeScreen() {
		changePanel(gui.welcomePanel);
		//fix lag
		gui.window.setVisible(true);
	}
	
	public void showClientScreen() {
		changePanel(gui.clientPanel);
		//fix lag
		gui.window.setVisible(true);
	}
	
	public void showOwnerScreen() {
		changePanel(gui.ownerPanel);
		//fix lag
		gui.window.setVisible(true);
	}

	private void changePanel(JPanel panel) {
	    gui.window.getContentPane().removeAll();
	    gui.window.getContentPane().add(panel);
	    gui.window.getContentPane().doLayout();
	  
	}
	
}
