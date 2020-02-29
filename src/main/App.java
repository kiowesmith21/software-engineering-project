package main;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class App {

	JFrame frame;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	
	public static void main(String[] args) {
		
		new App();
		
	}
	
	public App() {
		frame = new JFrame();
		
		frame.add(new ClientPanel());
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLayout(new GridLayout(2,1));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	
}
