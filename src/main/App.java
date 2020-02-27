package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

	InputHandler iHandler = new InputHandler();
	GUI gui = new GUI();
	VisibilityManager vs = new VisibilityManager(gui);
	
	public static void main(String[] args) {
		
		new App();
		
	}
	
	public App() {
		gui.createGUI(iHandler);
		vs.showWelcomeScreen();
	}
	
	//handles user input from buttons
	public class InputHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			
			switch(input) {
			case "owner" : vs.showOwnerScreen();
			break;
			
			case "client" : vs.showClientScreen();
			break;
			
			/*
			 * Will have submit buttons on owner screen and client screen that will save their info to a file
			case "submit" : vs.showClientScreen();
			break;
			*/
			
			}
		}
	}
	
}
